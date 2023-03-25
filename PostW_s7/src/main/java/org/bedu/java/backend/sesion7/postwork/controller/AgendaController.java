package org.bedu.java.backend.sesion7.postwork.controller;

import org.bedu.java.backend.sesion7.postwork.model.Persona;
import org.bedu.java.backend.sesion7.postwork.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AgendaController {
    private final AgendaService agendaService;

    @Autowired
    public AgendaController(AgendaService agendaService){
        this.agendaService = agendaService;
    }

    @GetMapping({"/", "/index"})
    public String formularioRegistro(Model model) {
        model.addAttribute("persona", new Persona());
        model.addAttribute("listaPersonas", agendaService.getPersonas());

        return "index";
    }

    @PostMapping("/registro")
    public ModelAndView registra(@Valid Persona persona, Errors errors) {
        agendaService.guardaPersona(persona);

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listaPersonas", agendaService.getPersonas());
        return mav;
    }

/*    @GetMapping
    public ResponseEntity<Set<Persona>> getPersonas(){
        return ResponseEntity.ok(agendaService.getPersonas());
    }

    @PostMapping
    public ResponseEntity<Persona> guardaPersona(@RequestBody Persona persona) {
        Persona resultado = agendaService.GuardaPersona(persona);

        if (resultado == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(resultado);
    }*/
}
