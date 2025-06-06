package fr.but3.gestion_alimentation.controllers;

import fr.but3.gestion_alimentation.model.Aliment;
import fr.but3.gestion_alimentation.model.AlimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlimentController {

    @Autowired
    private AlimentRepository alimentRepository;

    @GetMapping("/aliments")
    public String getAllAliments(Model model) {
        Iterable<Aliment> aliments = alimentRepository.findAll();
        model.addAttribute("aliments", aliments);
        return "Aliments"; // aliments.jsp
    }
}

