package org.bedu.java.backend.Postwork.runners;

import org.bedu.java.backend.Postwork.model.Persona;
import org.bedu.java.backend.Postwork.persistence.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PersonaRunner implements CommandLineRunner {
    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaRunner(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Persona persona1 = creaPersona("Hector", "5582110692");
        Persona persona2 = creaPersona("Ricardo", "5512345678");
        Persona persona3 = creaPersona("Hassan", "5511223344");
        Persona persona4 = creaPersona("Brandon", "5555667788");
        Persona persona5 = creaPersona("Miguel", "5587654321");

        List<Persona> personas = Arrays.asList(persona1, persona2, persona3, persona4, persona5);

        if (personaRepository.count() == 0){
            personaRepository.saveAll(personas);
        }

    }

    private Persona creaPersona(String nombre, String telefono) {
        Persona persona = new Persona();
        persona.setNombre(nombre);
        persona.setTelefono(telefono);

        return persona;
    }
}
