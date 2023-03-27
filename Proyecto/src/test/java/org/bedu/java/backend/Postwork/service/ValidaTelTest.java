package org.bedu.java.backend.Postwork.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidaTelTest {

    private ValidaTel validaTel = new ValidaTel();

    @Test
    void limpiaNumero() {
        assertEquals("5582110692", validaTel.limpiaNumero("(55) 8211 0692"));
        assertEquals("5512345678", validaTel.limpiaNumero("(55) 12-345-678"));
    }
}