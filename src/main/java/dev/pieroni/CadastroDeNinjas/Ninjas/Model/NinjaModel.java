package dev.pieroni.CadastroDeNinjas.Ninjas.Model;

import dev.pieroni.CadastroDeNinjas.Missions.Model.MissionsModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_registration")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "missions")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    private int age;

    private String rank;

    @ManyToOne
    @JoinColumn(name = "missions_id")
    private MissionsModel missions;


}
