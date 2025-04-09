package dev.pieroni.CadastroDeNinjas.Ninjas.Controller;

import dev.pieroni.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import dev.pieroni.CadastroDeNinjas.Ninjas.Service.NinjaService;
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

    // Create Ninja
    @PostMapping("/create")
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO newNinja = ninjaService.createNinja(ninja);

        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja by name " + newNinja.getName() + " and id " + newNinja.getId() + " created.");
    }


    // Search by ID
    @GetMapping("/searchID/{id}")
    public ResponseEntity<?> searchById(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.findById(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja with id " + id + " does not exist.");
        }

    }


    // Read Ninja data
    @GetMapping("/showall")
    public ResponseEntity<List<NinjaDTO>> showAll() {
        List<NinjaDTO> ninjaDTO = ninjaService.findAll();

        return ResponseEntity.ok(ninjaDTO);
    }


    // Update Ninja data
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaUpdate) {
        NinjaDTO ninjaUpdated = ninjaService.updateNinja(id, ninjaUpdate);
        if (ninjaUpdated != null) {
            return ResponseEntity.ok(ninjaUpdated);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja with id " + id + " does not exist.");
        }
    }


    // Delete Ninja
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteID(@PathVariable Long id) {
        if (ninjaService.findById(id) != null) {
            ninjaService.deleteNinja(id);

            return ResponseEntity.ok("Ninja with id " + id + " deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja with id " + id + " does not exist.");
        }
    }
}
