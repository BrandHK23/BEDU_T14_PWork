package org.bedu.java.backend.Postwork.service;

import org.bedu.java.backend.Postwork.persistence.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.bedu.java.backend.Postwork.model.Persona;

import java.util.List;
import java.util.Set;//validar
import java.util.stream.Collectors;

@Service
public class AgendaService {
    private final ValidaTel validaTel;
    private final FormatoTel formatoTel;
    private final PersonaRepository personaRepository;


    @Autowired
    public AgendaService(ValidaTel validaTel, PersonaRepository personaRepository, FormatoTel formatoTel){
        this.validaTel=validaTel;
        this.personaRepository=personaRepository;
        this.formatoTel = formatoTel;
    }

    public Persona guardaPersona(Persona persona){
       String telefono= validaTel.limpiaNumero(persona.getTelefono());
       persona.setTelefono(telefono);
       return personaRepository.save(persona);
    }//fin persona

    public List<Persona> getPersonas(){
        return personaRepository.findAll(Sort.by("nombre"))
                .stream()
                .map(registro -> {
                    registro.setTelefono(formatoTel.formatea(registro.getTelefono()));
                    return registro;
                }).collect(Collectors.toList());
    }

    public void borraPersona(Long Id) {
        personaRepository.deleteById(Id);
    }

    public String uniqueValidate(String nombre) {
        String err = "";
        if (personaRepository.findByNombre(nombre).size() != 0) {
            err += "Nombre ya existe";
        }

        return err;

    }
}
