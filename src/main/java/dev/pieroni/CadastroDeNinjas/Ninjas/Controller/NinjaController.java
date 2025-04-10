package dev.pieroni.CadastroDeNinjas.Ninjas.Controller;

import dev.pieroni.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import dev.pieroni.CadastroDeNinjas.Ninjas.Service.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/create")
    @Operation(summary = "Create a new ninja",
            description = "This route create a new ninja and insert it in the DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Ninja created successfully"),
            @ApiResponse(responseCode = "400",
                    description = "Error in ninja creation")
    })
    public ResponseEntity<String> createNinja(
            @Parameter(description = "User sends the information to be register in the database")
            @RequestBody NinjaDTO ninja) {
        NinjaDTO newNinja = ninjaService.createNinja(ninja);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja by name " + newNinja.getName() + " and id " + newNinja.getId() + " created.");
    }


    @GetMapping("/searchID/{id}")
    @Operation(summary = "Show ninja by ID",
            description = "This route search the ninja by the ID given and return it's information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Ninja founded successfully"),
            @ApiResponse(responseCode = "400",
                    description = "Error in found this ninja")
    })
    public ResponseEntity<?> searchById(
            @Parameter(description = "User send the id to be found in the URL path")
            @PathVariable Long id) {
        NinjaDTO ninja = ninjaService.findById(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja with id " + id + " does not exist.");
        }

    }


    @GetMapping("/showall")
    @Operation(summary = "Shows a list of all ninjas",
            description = "This route takes all the ninjas in the DB and returns it to the client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Ninjas founded successfully"),
            @ApiResponse(responseCode = "400",
                    description = "Error no ninja founded")
    })
    public ResponseEntity<List<NinjaDTO>> showAll() {
        List<NinjaDTO> ninjaDTO = ninjaService.findAll();

        return ResponseEntity.ok(ninjaDTO);
    }


    @PutMapping("/update/{id}")
    @Operation(summary = "Update ninja by ID",
            description = "This route update the ninja by the ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Ninja updated successfully"),
            @ApiResponse(responseCode = "400",
                    description = "Error ninja not founded, can't update it")
    })
    public ResponseEntity<?> updateNinja(
            @Parameter(description = "User send ID through the URL Path to select which ninja will be updated")
            @PathVariable Long id,
            @Parameter(description = "User sends the data to be updated")
            @RequestBody NinjaDTO ninjaUpdate) {
        NinjaDTO ninjaUpdated = ninjaService.updateNinja(id, ninjaUpdate);
        if (ninjaUpdated != null) {
            return ResponseEntity.ok(ninjaUpdated);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja with id " + id + " does not exist.");
        }
    }


    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete ninja by ID",
            description = "This route search the ninja by the ID given and deletes it")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Ninja deleted successfully"),
            @ApiResponse(responseCode = "400",
                    description = "Error in found this ninja, cannot be deleted")
    })
    public ResponseEntity<String> deleteID(
            @Parameter(description = "User send to the Path the ID to determinate which Ninja will be deleted")
            @PathVariable Long id) {
        if (ninjaService.findById(id) != null) {
            ninjaService.deleteNinja(id);

            return ResponseEntity.ok("Ninja with id " + id + " deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja with id " + id + " does not exist.");
        }
    }
}
