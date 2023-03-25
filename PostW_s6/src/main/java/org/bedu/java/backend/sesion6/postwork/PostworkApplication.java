package org.bedu.java.backend.sesion6.postwork;

import org.bedu.java.backend.sesion6.postwork.model.Persona;
import org.bedu.java.backend.sesion6.postwork.service.FormateadorTelefono;
import org.bedu.java.backend.sesion6.postwork.service.ValidadorTelefono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PostworkApplication implements CommandLineRunner {

	private final ValidadorTelefono validadorTelefono;
	private final FormateadorTelefono formateadorTelefono;

	@Autowired
	public PostworkApplication(ValidadorTelefono validadorTelefono, FormateadorTelefono formateadorTelefono) {
		this.validadorTelefono = validadorTelefono;
		this.formateadorTelefono = formateadorTelefono;
	}

	public static void main(String[] args) {
		SpringApplication.run(PostworkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nombre: ");
		String nombre = scanner.nextLine();

		System.out.print("Telefono: ");
		String telefono = scanner.nextLine();

		if(validadorTelefono.isValid(telefono)) {
			telefono = validadorTelefono.limpiaNumero(telefono);
			telefono = formateadorTelefono.formatea(telefono);

			Persona persona = new Persona(nombre, telefono);
			System.out.println(persona);
		} else {
			System.out.println("El numero que introdujo no es valido");
		}
	}
}
