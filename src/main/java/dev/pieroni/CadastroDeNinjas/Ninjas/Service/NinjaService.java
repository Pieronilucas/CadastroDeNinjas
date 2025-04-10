package dev.pieroni.CadastroDeNinjas.Ninjas.Service;

import dev.pieroni.CadastroDeNinjas.Missions.DTO.MissionsDTO;
import dev.pieroni.CadastroDeNinjas.Missions.Mapper.MissionsMapper;
import dev.pieroni.CadastroDeNinjas.Missions.Model.MissionsModel;
import dev.pieroni.CadastroDeNinjas.Missions.Repository.MissionsRepository;
import dev.pieroni.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import dev.pieroni.CadastroDeNinjas.Ninjas.Mapper.NinjaMapper;
import dev.pieroni.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.pieroni.CadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;
    private final MissionsRepository missionsRepository;
    private final MissionsMapper missionsMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper, MissionsRepository missionsRepository, MissionsMapper missionsMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
        this.missionsRepository = missionsRepository;
        this.missionsMapper = missionsMapper;
    }

    // Show all ninjas
    public List<NinjaDTO> findAll() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();

        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }


    // Show ninja by ID
    public NinjaDTO findById(Long id) {
        Optional<NinjaModel> ninjaById = ninjaRepository.findById(id);
        return ninjaById.map(ninjaMapper::map).orElse(null);
    }

    // Create a ninja
    public NinjaDTO createNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        ninjaModel = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    // Delete ninja by ID
    public void deleteNinja(Long id) {
        ninjaRepository.deleteById(id);
    }

    // Update Ninja
    public NinjaDTO updateNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaId = ninjaRepository.findById(id);
        if (ninjaId.isPresent()) {
            NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
            ninjaModel.setId(id);
            ninjaModel = ninjaRepository.save(ninjaModel);
            return ninjaMapper.map(ninjaModel);
        }
        return null;

    }
    public List<MissionsDTO> getAllMissions() {
        List<MissionsModel> missions = missionsRepository.findAll();
        return missions.stream().map(missionsMapper::map).collect(Collectors.toList());
    }


}
