package org.bedu.java.backend.sesion8.controller;

import org.bedu.java.backend.sesion8.model.Producto;
import org.bedu.java.backend.sesion8.persistence.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoController(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
        Producto productoDB = productoRepository.save(producto);

        return ResponseEntity.created(URI.create(productoDB.getId().toString())).build();
    }

    @GetMapping("/{productoId}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Long productoId){

        Optional<Producto> productoDB  = productoRepository.findById(productoId);

        if (!productoDB.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El producto solicitado no existe");
        }

        return ResponseEntity.ok(productoDB.get());

    }

}
