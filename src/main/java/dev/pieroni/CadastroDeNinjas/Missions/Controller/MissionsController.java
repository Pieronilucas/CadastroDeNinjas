package dev.pieroni.CadastroDeNinjas.Missions.Controller;

import dev.pieroni.CadastroDeNinjas.Missions.DTO.MissionsDTO;
import dev.pieroni.CadastroDeNinjas.Missions.Service.MissionsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mission")
public class MissionsController {
    private MissionsService missionsService;

    public MissionsController(MissionsService missionsService) {
        this.missionsService = missionsService;
    }

    // Create missions
    @PostMapping("/create")
    public MissionsDTO createMission(@RequestBody MissionsDTO missionsDTO) {
        return missionsService.createMission(missionsDTO);
    }

    // Search by ID
    @GetMapping("/searchID/{id}")
    public MissionsDTO searchMissionID(@PathVariable Long id) {
        return missionsService.findById(id);
    }


    // Read Ninja data
    @GetMapping("/showall")
    public List<MissionsDTO> showAllMissions() {
        return missionsService.showall();
    }


    // Update Ninja data
    @PutMapping("/update/{id}")
    public MissionsDTO updateMission(@PathVariable Long id, @RequestBody MissionsDTO missionsDTO) {
        return missionsService.updateMission(id, missionsDTO);
    }


    // Delete Ninja
    @DeleteMapping("/deleteID/{id}")
    public void deleteID(@PathVariable Long id) {
        missionsService.deleteMission(id);
    }

}
