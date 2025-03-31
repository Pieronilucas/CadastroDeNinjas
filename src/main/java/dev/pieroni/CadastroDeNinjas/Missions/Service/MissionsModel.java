package dev.pieroni.CadastroDeNinjas.Missions.Service;


import dev.pieroni.CadastroDeNinjas.Ninjas.Service.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_missions")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class MissionsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String difficulty;
    @OneToMany(mappedBy = "missions")
    private List<NinjaModel> ninja;


}
