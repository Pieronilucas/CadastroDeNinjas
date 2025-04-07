package dev.pieroni.CadastroDeNinjas.Missions.Mapper;

import dev.pieroni.CadastroDeNinjas.Missions.DTO.MissionsDTO;
import dev.pieroni.CadastroDeNinjas.Missions.Model.MissionsModel;
import org.springframework.stereotype.Component;

@Component
public class MissionsMapper {

    public MissionsModel map(MissionsDTO missionsDTO) {
        MissionsModel missionsModel = new MissionsModel();
        missionsModel.setId(missionsDTO.getId());
        missionsModel.setName(missionsDTO.getName());
        missionsModel.setDifficulty(missionsDTO.getDifficulty());
        missionsModel.setNinja(missionsDTO.getNinja());

        return missionsModel;
    }

    public MissionsDTO map(MissionsModel missionsModel) {
        MissionsDTO missionsDTO = new MissionsDTO();
        missionsDTO.setId(missionsModel.getId());
        missionsDTO.setName(missionsModel.getName());
        missionsDTO.setDifficulty(missionsModel.getDifficulty());
        missionsDTO.setNinja(missionsModel.getNinja());

        return missionsDTO;
    }
}
