package dev.pieroni.CadastroDeNinjas.Missions.Controller;

import dev.pieroni.CadastroDeNinjas.Missions.DTO.MissionsDTO;
import dev.pieroni.CadastroDeNinjas.Missions.Service.MissionsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mission/ui")
public class MissionsControllerUi {
    private final MissionsService missionsService;

    public MissionsControllerUi(MissionsService missionsService) {
        this.missionsService = missionsService;
    }

    @GetMapping("/showall")
    public String showAll(Model model) {
        List<MissionsDTO> missions = missionsService.showall();
        model.addAttribute("missions", missions);
        return "showMissions";
    }

    @GetMapping("/delete/{id}")
    public String deleteID(@PathVariable Long id) {
        missionsService.deleteMission(id);
        return "redirect:/mission/ui/showall";
    }
}
