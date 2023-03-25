package org.bedu.java.backend.sesion8.persistence;

import org.bedu.java.backend.sesion8.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
