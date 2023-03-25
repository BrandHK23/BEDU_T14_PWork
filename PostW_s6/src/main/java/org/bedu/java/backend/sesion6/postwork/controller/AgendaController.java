package org.bedu.java.backend.sesion6.postwork.controller;

import org.bedu.java.backend.sesion6.postwork.model.Persona;
import org.bedu.java.backend.sesion6.postwork.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/agenda")
public class AgendaController {
    private final AgendaService agendaService;

    @Autowired
    public AgendaController(AgendaService agendaService){
        this.agendaService = agendaService;
    }

    @GetMapping
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
    }
}
