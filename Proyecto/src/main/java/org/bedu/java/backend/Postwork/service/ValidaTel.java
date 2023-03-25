package org.bedu.java.backend.Postwork.service;
import org.springframework.stereotype.Service;

@Service
public class ValidaTel {
       public String limpiaNumero(String telefono){
        return telefono.replaceAll("[^0-9]", "");
    }
}