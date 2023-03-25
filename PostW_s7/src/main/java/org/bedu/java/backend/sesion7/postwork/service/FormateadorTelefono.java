package org.bedu.java.backend.sesion7.postwork.service;

import org.springframework.stereotype.Service;

@Service
public class FormateadorTelefono {
    private static final String FORMATO_INICIAL = "(\\d{2})(\\d{4})(\\d{4})";
    private static final String FORMATO_FINAL = "($1)-$2-$3";

    public String formatea(String telefono) {
        return telefono.replaceFirst(FORMATO_INICIAL, FORMATO_FINAL);
    }
}
