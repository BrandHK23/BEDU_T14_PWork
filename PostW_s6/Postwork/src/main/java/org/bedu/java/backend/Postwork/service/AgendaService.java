package org.bedu.java.backend.Postwork.service;

import org.bedu.java.backend.Postwork.model.Persona;
import org.bedu.java.backend.Postwork.persistence.AgendaMemoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AgendaService {
    private final ValidaTelefono validaTelefono;
    private final AgendaMemoryDao agendaMemoryDao;

    @Autowired
    public AgendaService(ValidaTelefono validaTelefono, AgendaMemoryDao agendaMemoryDao){
        this.validaTelefono = validaTelefono;
        this.agendaMemoryDao = agendaMemoryDao;
    }

    public Persona guardaPersona(Persona persona){
        if(!validaTelefono.isValido(persona.getTelefono())){
            return null;
        }
        String telefono = validaTelefono.limpiaNumero(persona.getTelefono());

        persona.setTelefono(telefono);
        return agendaMemoryDao.guardaPersona(persona);
    }
    public Set<Persona> getPersonas(){
        return agendaMemoryDao.getPersonas();
    }
}
