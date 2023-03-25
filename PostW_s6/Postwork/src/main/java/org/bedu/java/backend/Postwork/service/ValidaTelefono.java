package org.bedu.java.backend.Postwork.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidaTelefono {
    private static final Pattern PATTERN_TELEFONO = Pattern.compile("^(\\d{2,4}[- .]?){2}\\d{4}$");

    public boolean isValido(String telefono){
        return PATTERN_TELEFONO.matcher(telefono).matches();
    }
    public String limpiaNumero(String telefono){
        return telefono.replaceAll("[^0-9]", "");
    }
}
