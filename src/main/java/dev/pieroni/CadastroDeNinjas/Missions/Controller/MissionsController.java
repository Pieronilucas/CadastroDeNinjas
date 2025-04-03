package dev.pieroni.CadastroDeNinjas.Missions.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MissionsController {

    @GetMapping("/missionsset")
    public String missionsset() {return "Welcome to missions controller";}

    // Create missions
    @PostMapping("/createmission")
    public String createMission(){
        return "Mission created";
    }

    // Search by ID
    @GetMapping("/searchmissionsID")
    public String searchmissionsID(){
        return "Welcome to search missions controller";
    }


    // Read Ninja data
    @GetMapping("/showallmissions")
    public String showallmissions(){
        return "Welcome to show missions controller";
    }


    // Update Ninja data
    @PutMapping("/updatemission")
    public String updatemission(){
        return "Mission updated";
    }


    // Delete Ninja
    @DeleteMapping("/deletemissionsID")
    public String deletemissionsID(){
        return "Mission deleted";
    }

}
