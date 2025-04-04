package dev.pieroni.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {


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
    public String showAll(){
        return "Show all";
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
