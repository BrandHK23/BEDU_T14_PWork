package org.bedu.java.backend.Postwork.controller;

import org.bedu.java.backend.Postwork.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.bedu.java.backend.Postwork.service.AgendaService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;

@Controller
public class AgendaController {
    private final AgendaService agendaService;

    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }
    @GetMapping({"/", "/index"})
    public String formularioRegistro(Model model){
        model.addAttribute("persona", new Persona());
        model.addAttribute("listaPersonas", agendaService.getPersonas());
        return "index";
    }

@PostMapping("/registro")
    public ModelAndView registra(@Valid Persona persona){
        agendaService.guardaPersona(persona);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("listaPersonas",agendaService.getPersonas());
        return modelAndView;
    }
}
