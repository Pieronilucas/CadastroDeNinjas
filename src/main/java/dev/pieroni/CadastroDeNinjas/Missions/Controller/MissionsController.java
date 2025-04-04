package dev.pieroni.CadastroDeNinjas.Missions.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mission")
public class MissionsController {

    // Create missions
    @PostMapping("/create")
    public String createMission(){
        return "Mission created";
    }

    // Search by ID
    @GetMapping("/searchID")
    public String searchMissionID(){
        return "Welcome to search missions controller";
    }


    // Read Ninja data
    @GetMapping("/showall")
    public String showAllMissions(){
        return "Welcome to show missions controller";
    }


    // Update Ninja data
    @PutMapping("/update")
    public String updateMission(){
        return "Mission updated";
    }


    // Delete Ninja
    @DeleteMapping("/deleteID")
    public String deleteID(){
        return "Mission deleted";
    }

}
