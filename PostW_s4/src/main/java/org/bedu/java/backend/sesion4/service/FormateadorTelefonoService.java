package org.bedu.java.backend.sesion4.service;

import org.springframework.stereotype.Service;

@Service
public class FormateadorTelefonoService {
    private static final String FORMATO_INICIAL = "(\\d{2})(\\d{4})(\\d+)";
    private static final String FORMATO_FINAL = "($1)-$2-$3";

    public String formatea(String telefono){
        //System.out.println(telefono.replaceFirst(FORMATO_INICIAL, FORMATO_FINAL));
        return telefono.replaceFirst(FORMATO_INICIAL, FORMATO_FINAL);
    }
}
