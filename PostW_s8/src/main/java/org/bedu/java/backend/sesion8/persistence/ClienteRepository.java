package org.bedu.java.backend.sesion8.persistence;

import org.bedu.java.backend.sesion8.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
