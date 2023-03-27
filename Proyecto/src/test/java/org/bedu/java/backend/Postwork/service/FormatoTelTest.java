package org.bedu.java.backend.Postwork.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormatoTelTest {
    private  FormatoTel formatoTel = new FormatoTel();


    @Test
    void formatea() {
        assertEquals("(55)-8211-0692", formatoTel.formatea("5582110692"));
        assertEquals("(55)-1234-5678", formatoTel.formatea("5512345678"));
    }
}