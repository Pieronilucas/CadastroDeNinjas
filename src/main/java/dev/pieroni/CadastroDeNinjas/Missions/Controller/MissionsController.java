package dev.pieroni.CadastroDeNinjas.Missions.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MissionsController {

    @GetMapping("/welcome2")
    public String welcome2() {return "Welcome to missions controller";}

}
