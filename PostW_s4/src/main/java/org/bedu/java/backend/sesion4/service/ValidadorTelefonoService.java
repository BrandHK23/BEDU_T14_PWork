package org.bedu.java.backend.sesion4.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidadorTelefonoService {
    private static final Pattern PATTERN = Pattern.compile("^(\\d{2}|\\(\\d{2}\\))[- ]?\\d{4}[- ]?\\d{4}$");

    public Boolean esValido(String telefono){
        //System.out.println(PATTERN.matcher(telefono).matches());
        return PATTERN.matcher(telefono).matches();
    }

    public String limpiarTelefono(String telefono){
        //System.out.println(telefono.replaceAll("[^0-9]", ""));
        return telefono.replaceAll("[^0-9]", "");
    }




}
