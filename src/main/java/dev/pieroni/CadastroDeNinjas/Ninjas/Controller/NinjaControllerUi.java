package dev.pieroni.CadastroDeNinjas.Ninjas.Controller;

import dev.pieroni.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import dev.pieroni.CadastroDeNinjas.Ninjas.Service.NinjaService;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {
    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    @GetMapping("/showall")
    public String showAll(Model model) {
        List<NinjaDTO> ninjaDTO = ninjaService.findAll();
        model.addAttribute("ninjas", ninjaDTO);
        return "showNinjas";
    }

    @GetMapping("/delete/{id}")
    public String deleteID(@PathVariable Long id) {
        ninjaService.deleteNinja(id);
        return "redirect:/ninjas/ui/showall";
    }

    @GetMapping("/searchID/{id}")
    public String searchById(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.findById(id);
        if (ninja != null) {
            model.addAttribute("ninjas", ninja);
            return "ninjaDetails";
        } else {
            model.addAttribute("message", "Ninja not founded");
            return "showNinjas";
        }

    }

    @GetMapping("/add")
    public String formAddNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        model.addAttribute("missions", ninjaService.getAllMissions());
        return "addNinja";
    }

    @PostMapping("/save")
    public String salveNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        ninjaService.createNinja(ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja successfully added!");
        return "redirect:ninjas/ui/addNinja";
    }

}
