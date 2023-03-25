package org.bedu.java.backend.sesion6.postwork.service;

import org.springframework.stereotype.Service;

@Service
public class ValidadorTelefono {
    public boolean isValid(String telefono) {
        if (telefono.matches("^[0-9 -]+$")){
            return telefono.replaceAll("\\D", "").length() == 10;
        }
        return false;
    }

    public String limpiaNumero(String telefono) {
        return telefono.replaceAll("\\D", "");
    }
}
