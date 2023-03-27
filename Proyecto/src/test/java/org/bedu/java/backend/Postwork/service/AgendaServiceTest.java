package org.bedu.java.backend.Postwork.service;

import org.bedu.java.backend.Postwork.model.Persona;
import org.bedu.java.backend.Postwork.persistence.PersonaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AgendaServiceTest {
    @InjectMocks
    AgendaService agendaService;
    @Mock
    ValidaTel validaTel;

    @Mock
    FormatoTel formatoTel;

    @Mock
    PersonaRepository personaRepository;

    @Test
    void guardaPersona() {
        Persona persona = new Persona();
        persona.setNombre("Hector");
        persona.setTelefono("5582110692");

        agendaService.guardaPersona(persona);
        verify(personaRepository, times(1)).save(persona);
    }

    @Test
    void getPersonas() {
        List<Persona> personas = new ArrayList<>();

        Persona persona1 = new Persona();
        persona1.setNombre("Hector");
        persona1.setTelefono("5582110692");

        Persona persona2 = new Persona();
        persona2.setNombre("Ricardo");
        persona2.setTelefono("5512345678");

        personas.add(persona1);
        personas.add(persona2);

        when(personaRepository.findAll(Sort.by("nombre"))
                .stream()
                .map(registro -> {
                    registro.setTelefono(formatoTel.formatea(registro.getTelefono()));
                    return registro;
                }).collect(Collectors.toList())).thenReturn(personas);

        List<Persona> empList = agendaService.getPersonas();

        assertEquals(2, empList.size());

    }

    @Test
    void borraPersona() {
        long id = 1;
        agendaService.borraPersona(id);

        verify(personaRepository, times(1)).deleteById(id);

    }

}