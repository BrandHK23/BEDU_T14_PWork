package org.bedu.java.backend.sesion6.postwork.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormateadorTelefonoTest {
    private or.bedu.java.backend.sesion5.postwork.service.FormateadorTelefono formateadorTelefono = new or.bedu.java.backend.sesion5.postwork.service.FormateadorTelefono();

    @Test
    void formatea() {
        assertEquals("(55)-8211-0692", formateadorTelefono.formatea("5582110692"));
        assertEquals("(55)-1234-5678", formateadorTelefono.formatea("5512345678"));
    }
}