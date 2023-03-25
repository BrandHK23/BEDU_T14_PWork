package org.bedu.java.backend.Postwork.persistence;

import org.bedu.java.backend.Postwork.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
