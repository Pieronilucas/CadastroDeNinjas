package dev.pieroni.CadastroDeNinjas.Ninjas.Controller;

import dev.pieroni.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.pieroni.CadastroDeNinjas.Ninjas.Repository.NinjaRepository;
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
    public String createNinja(){
        return "Ninja created";
    }


    // Search by ID
    @GetMapping("/searchID")
    public String searchID(){
        return "Search ID";
    }


    // Read Ninja data
    @GetMapping("/showall")
    public List<NinjaModel> showAll(){
        return ninjaService.findAll();
    }


    // Update Ninja data
     @PutMapping("/update")
     public String updateNinja(){
        return "Ninja updated";
     }


    // Delete Ninja
    @DeleteMapping("/deleteID")
    public String deleteID(){
        return "Delete ID";
    }


}
