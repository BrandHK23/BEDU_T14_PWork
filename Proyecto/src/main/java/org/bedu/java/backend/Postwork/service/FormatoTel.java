package org.bedu.java.backend.Postwork.service;
import org.springframework.stereotype.Service;
@Service
public class FormatoTel {
    private static final String ENCAPSULADO = "(\\d{2})(\\d{4})(\\d+)";
    private static final String FORMATO = "($1)-$2-$3";

    public String formatea(String telefono) {
        return String.valueOf(telefono).replaceFirst(ENCAPSULADO,FORMATO);
    }
}
