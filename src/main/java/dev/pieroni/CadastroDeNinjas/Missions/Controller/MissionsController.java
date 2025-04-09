package dev.pieroni.CadastroDeNinjas.Missions.Controller;

import dev.pieroni.CadastroDeNinjas.Missions.DTO.MissionsDTO;
import dev.pieroni.CadastroDeNinjas.Missions.Service.MissionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createMission(@RequestBody MissionsDTO missionsDTO) {
        MissionsDTO missionCreated = missionsService.createMission(missionsDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(missionCreated.toString());
    }

    // Search by ID
    @GetMapping("/searchID/{id}")
    public ResponseEntity<?> searchMissionID(@PathVariable Long id) {
        MissionsDTO missionsDTO = missionsService.findById(id);
        if (missionsDTO != null) {

            return ResponseEntity.ok(missionsDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID not found");
        }
    }


    // Read Ninja data
    @GetMapping("/showall")
    public ResponseEntity<List<MissionsDTO>> showAllMissions() {
        List<MissionsDTO> missionsDTO = missionsService.showall();

        return ResponseEntity.ok(missionsDTO);
    }


    // Update Ninja data
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMission(@PathVariable Long id, @RequestBody MissionsDTO missionsDTO) {
        MissionsDTO missionsUpdated = missionsService.updateMission(id, missionsDTO);
        if (missionsUpdated != null) {
            return ResponseEntity.ok(missionsUpdated);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja by invalid ID. ID: " + id);
        }
    }


    // Delete Ninja
    @DeleteMapping("/deleteID/{id}")
    public ResponseEntity<String> deleteID(@PathVariable Long id) {
        if (missionsService.findById(id) != null) {
            missionsService.deleteMission(id);

            return ResponseEntity.ok("Mission by ID " + id + " deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mission by ID " + id + " not found.");
        }
    }
}
