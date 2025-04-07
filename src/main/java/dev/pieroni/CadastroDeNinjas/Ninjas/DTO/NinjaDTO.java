package dev.pieroni.CadastroDeNinjas.Ninjas.DTO;

import dev.pieroni.CadastroDeNinjas.Missions.Model.MissionsModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String name;
    private String email;
    private String imgUrl;
    private int age;
    private String rank;
    private MissionsModel missions;


}
