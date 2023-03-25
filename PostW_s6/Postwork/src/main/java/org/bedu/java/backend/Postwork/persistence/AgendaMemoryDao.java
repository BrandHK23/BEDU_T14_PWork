package org.bedu.java.backend.Postwork.persistence;

import org.bedu.java.backend.Postwork.model.Persona;
import org.bedu.java.backend.Postwork.service.FormateaTelefono;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Repository
public class AgendaMemoryDao {

    private static final SortedSet<Persona> personas = new TreeSet<>();
    private final FormateaTelefono formateaTelefono;

    public AgendaMemoryDao(FormateaTelefono formateaTelefono){
        this.formateaTelefono = formateaTelefono;
    }

    public Persona guardaPersona(Persona persona){
        persona.setTelefono(formateaTelefono.formatea(persona.getTelefono()));
        return persona;
    }
    public Set<Persona>getPersonas(){
        return personas;
    }
}
