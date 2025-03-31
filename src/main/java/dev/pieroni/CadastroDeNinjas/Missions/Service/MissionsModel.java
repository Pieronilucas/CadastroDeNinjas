package dev.pieroni.CadastroDeNinjas.Missions.Service;


import dev.pieroni.CadastroDeNinjas.Ninjas.Service.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missions")
public class MissionsModel {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String difficulty;
    @OneToMany(mappedBy = "missions")
    private List<NinjaModel> ninja;


}
