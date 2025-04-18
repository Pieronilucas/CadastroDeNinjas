package dev.pieroni.CadastroDeNinjas.Missions.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.pieroni.CadastroDeNinjas.Ninjas.Model.NinjaModel;
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
@ToString(exclude = "ninja")
public class MissionsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String difficulty;

    @OneToMany(mappedBy = "missions")
    @JsonIgnore
    private List<NinjaModel> ninja;


}
