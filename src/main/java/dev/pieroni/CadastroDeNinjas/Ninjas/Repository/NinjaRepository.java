package dev.pieroni.CadastroDeNinjas.Ninjas.Repository;

import dev.pieroni.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
