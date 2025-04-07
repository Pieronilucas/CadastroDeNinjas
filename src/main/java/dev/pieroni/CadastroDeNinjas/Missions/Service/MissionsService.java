package dev.pieroni.CadastroDeNinjas.Missions.Service;

import dev.pieroni.CadastroDeNinjas.Missions.DTO.MissionsDTO;
import dev.pieroni.CadastroDeNinjas.Missions.Mapper.MissionsMapper;
import dev.pieroni.CadastroDeNinjas.Missions.Model.MissionsModel;
import dev.pieroni.CadastroDeNinjas.Missions.Repository.MissionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissionsService {

    private MissionsRepository missionsRepository;
    private MissionsMapper missionsMapper;

    public MissionsService(MissionsRepository missionsRepository, MissionsMapper missionsMapper) {
        this.missionsRepository = missionsRepository;
        this.missionsMapper = missionsMapper;
    }

    // Show all missions
    public List<MissionsDTO> showall() {
        List<MissionsModel> missions = missionsRepository.findAll();

        return missions.stream().map(missionsMapper::map).collect(Collectors.toList());
    }


    // Show mission by ID
    public MissionsDTO findById(Long id) {
        Optional<MissionsModel> missionsById = missionsRepository.findById(id);
        return missionsById.map(missionsMapper::map).orElse(null);
    }

    // Create a mission
    public MissionsDTO createMission(MissionsDTO missionsDTO) {
        MissionsModel missionsModel = missionsMapper.map(missionsDTO);
        missionsRepository.save(missionsModel);

        return missionsMapper.map(missionsModel);
    }

    // Delete mission by ID
    public void deleteMission(Long id) {
        missionsRepository.deleteById(id);
    }

    // Update mission
    public MissionsDTO updateMission(Long id ,MissionsDTO missionsDTO) {
        Optional<MissionsModel> missionsId = missionsRepository.findById(id);
        if (missionsId.isPresent()) {
            MissionsModel missionsModel = missionsMapper.map(missionsDTO);
            missionsModel.setId(id);
            missionsRepository.save(missionsModel);

            return missionsMapper.map(missionsModel);
        }
        return null;
    }

}
