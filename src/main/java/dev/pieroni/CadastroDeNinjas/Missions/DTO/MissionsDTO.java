package dev.pieroni.CadastroDeNinjas.Missions.DTO;

import dev.pieroni.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissionsDTO {

    private Long id;
    private String name;
    private String difficulty;
    private List<NinjaModel> ninja;


}
