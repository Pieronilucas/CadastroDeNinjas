package dev.pieroni.CadastroDeNinjas.Missions.Repository;

import dev.pieroni.CadastroDeNinjas.Missions.Model.MissionsModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MissionsRepository extends JpaRepository<MissionsModel, Long> {
}
