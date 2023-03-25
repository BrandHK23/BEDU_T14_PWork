package org.bedu.java.backend.sesion7.postwork.model;



import java.util.ArrayList;
import java.util.List;

public class Personas {
    private List<Persona> personas;

    public Personas() {
        this.personas = new ArrayList<>();
    }
    public Persona getPersona(String nombre) {
        for (Persona persona: personas) {
            if(persona.getNombre().equals(nombre)) {
                return persona;
            }
        }
        return null;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void addPersona(Persona persona){
        personas.add(persona);
    }

    //Delete

    //update



}
