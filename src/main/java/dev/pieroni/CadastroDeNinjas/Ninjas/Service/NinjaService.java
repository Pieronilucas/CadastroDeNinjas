package dev.pieroni.CadastroDeNinjas.Ninjas.Service;

import dev.pieroni.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.pieroni.CadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Show all ninjas
    public List<NinjaModel> findAll() {
        return ninjaRepository.findAll();
    }


    // Show ninja by ID
    public NinjaModel findById(Long id) {
        Optional<NinjaModel> ninjaById = ninjaRepository.findById(id);
        return ninjaById.orElse(null);
    }

    // Create a ninja
    public NinjaModel createNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    // Delete ninja by ID
    public void deleteNinja(Long id) {
        ninjaRepository.deleteById(id);
    }



}
