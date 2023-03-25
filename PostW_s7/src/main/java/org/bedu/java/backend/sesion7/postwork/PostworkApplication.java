package org.bedu.java.backend.sesion7.postwork;

import org.bedu.java.backend.sesion7.postwork.model.Persona;
import org.bedu.java.backend.sesion7.postwork.service.FormateadorTelefono;
import org.bedu.java.backend.sesion7.postwork.service.ValidadorTelefono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PostworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostworkApplication.class, args);
	}


}
