package dev.pieroni.CadastroDeNinjas.Missions.Controller;

import dev.pieroni.CadastroDeNinjas.Missions.DTO.MissionsDTO;
import dev.pieroni.CadastroDeNinjas.Missions.Service.MissionsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mission")
public class MissionsController {
    private final MissionsService missionsService;

    public MissionsController(MissionsService missionsService) {
        this.missionsService = missionsService;
    }

    @PostMapping("/create")
    @Operation(summary = "Create a new mission",
            description = "This route create a new mission and insert it in the DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Mission created successfully"),
            @ApiResponse(responseCode = "400",
                    description = "Error in mission creation")
    })
    public ResponseEntity<String> createMission(
            @Parameter(description = "User sends the information to be register in the database")
            @RequestBody MissionsDTO missionsDTO) {
        MissionsDTO missionCreated = missionsService.createMission(missionsDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(missionCreated.toString());
    }


    @GetMapping("/searchID/{id}")
    @Operation(summary = "Show mission by ID",
            description = "This route search the mission by the ID given and return it's information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Mission founded successfully"),
            @ApiResponse(responseCode = "400",
                    description = "Error in found this mission")
    })
    public ResponseEntity<?> searchMissionID(
            @Parameter(description = "User send the id to be found in the URL path")
            @PathVariable Long id) {
        MissionsDTO missionsDTO = missionsService.findById(id);
        if (missionsDTO != null) {

            return ResponseEntity.ok(missionsDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID not found");
        }
    }


    @GetMapping("/showall")
    @Operation(summary = "Shows a list of all missions",
            description = "This route takes all the missions in the DB and returns it to the client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Missions founded successfully"),
            @ApiResponse(responseCode = "400",
                    description = "Error no mission founded")
    })
    public ResponseEntity<List<MissionsDTO>> showAllMissions() {
        List<MissionsDTO> missionsDTO = missionsService.showall();

        return ResponseEntity.ok(missionsDTO);
    }


    @PutMapping("/update/{id}")
    @Operation(summary = "Update mission by ID",
            description = "This route update the mission by the ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Mission updated successfully"),
            @ApiResponse(responseCode = "400",
                    description = "Error mission not founded, cannot update it")
    })
    public ResponseEntity<?> updateMission(
            @Parameter(description = "User send ID through the URL Path to select which mission will be update")
            @PathVariable Long id,
            @Parameter(description = "User sends the data to be updated")
            @RequestBody MissionsDTO missionsDTO) {
        MissionsDTO missionsUpdated = missionsService.updateMission(id, missionsDTO);
        if (missionsUpdated != null) {
            return ResponseEntity.ok(missionsUpdated);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mission ID is invalid! ID: " + id);
        }
    }


    @DeleteMapping("/deleteID/{id}")
    @Operation(summary = "Delete Mission by ID",
            description = "This route search the mission by the ID given and deletes it")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Mission deleted successfully"),
            @ApiResponse(responseCode = "400",
                    description = "Error in found this mission, cannot be deleted")
    })
    public ResponseEntity<String> deleteID(
            @Parameter(description = "User send to the Path the ID to determinate which Mission will be delete")
            @PathVariable Long id) {
        if (missionsService.findById(id) != null) {
            missionsService.deleteMission(id);

            return ResponseEntity.ok("Mission by ID " + id + " deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mission by ID " + id + " not found.");
        }
    }
}
