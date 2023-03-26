package org.bedu.java.backend.Postwork.controller;

import org.bedu.java.backend.Postwork.model.Persona;
import org.bedu.java.backend.Postwork.service.AgendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AgendaController {
    private final AgendaService agendaService;

    @Autowired
    public AgendaController(AgendaService agendaService){
        this.agendaService=agendaService;
    }


   @GetMapping({"/", "/index"})
    public String formularioRegistro(Model model) {
        model.addAttribute("persona",new Persona());
        model.addAttribute("listaPersonas",agendaService.getPersonas());

        return "index";
    }

    @PostMapping("/registro")
    public ModelAndView registra(@Valid Persona persona, BindingResult result){
        ModelAndView modelAndView = new ModelAndView("index");
        String err = agendaService.uniqueValidate(persona.getNombre());

        if (!err.isEmpty()) {
            ObjectError error = new ObjectError("globalError", err);
            result.addError(error);
        }

        if(!result.hasErrors()){
            agendaService.guardaPersona(persona);
        }


        modelAndView.addObject("listaPersonas",agendaService.getPersonas());
        return modelAndView;
    }

    @GetMapping("/deletePersona")
    public String deletePersona(@RequestParam Long Id) {
        agendaService.borraPersona(Id);
        return "redirect:/index";
    }



}//fin de clase
