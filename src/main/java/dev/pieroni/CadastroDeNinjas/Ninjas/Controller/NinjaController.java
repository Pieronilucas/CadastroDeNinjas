package dev.pieroni.CadastroDeNinjas.Ninjas.Controller;

import dev.pieroni.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import dev.pieroni.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.pieroni.CadastroDeNinjas.Ninjas.Service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {


    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Create Ninja
    @PostMapping("/create")
    public NinjaDTO createNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.createNinja(ninja);
    }


    // Search by ID
    @GetMapping("/searchID/{id}")
    public NinjaModel searchById(@PathVariable Long id) {
        return ninjaService.findById(id);
    }


    // Read Ninja data
    @GetMapping("/showall")
    public List<NinjaModel> showAll() {
        return ninjaService.findAll();
    }


    // Update Ninja data
    @PutMapping("/update/{id}")
    public NinjaModel updateNinja(@PathVariable Long id, @RequestBody NinjaModel ninjaUpdate) {
        return ninjaService.updateNinja(id, ninjaUpdate);
    }


    // Delete Ninja
    @DeleteMapping("/delete/{id}")
    public void deleteID(@PathVariable Long id) {
        ninjaService.deleteNinja(id);
    }


}
