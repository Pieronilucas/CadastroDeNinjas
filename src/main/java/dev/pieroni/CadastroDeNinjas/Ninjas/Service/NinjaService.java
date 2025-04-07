package dev.pieroni.CadastroDeNinjas.Ninjas.Service;

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

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
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


}
