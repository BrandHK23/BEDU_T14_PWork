package org.bedu.java.backend.sesion7.postwork.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorTelefonoTest {
    private or.bedu.java.backend.sesion5.postwork.service.ValidadorTelefono validadorTelefono = new or.bedu.java.backend.sesion5.postwork.service.ValidadorTelefono();

    @Test
    void isValid() {
        assertTrue(validadorTelefono.isValid("55 8211-0692"));
        assertFalse(validadorTelefono.isValid("(55) 8211-0692"));
        assertFalse(validadorTelefono.isValid("55abc8$ 211043"));
        assertFalse(validadorTelefono.isValid("55 8211-06921"));
    }

    @Test
    void limpiaNumero() {
        assertEquals("5582110692", validadorTelefono.limpiaNumero("(55) 8211 0692"));
        assertEquals("5512345678", validadorTelefono.limpiaNumero("(55) 12-345-678"));
    }
}