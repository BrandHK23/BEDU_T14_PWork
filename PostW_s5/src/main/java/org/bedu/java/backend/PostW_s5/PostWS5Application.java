package org.bedu.java.backend.PostW_s5;

import org.bedu.java.backend.PostW_s5.model.Persona;
import org.bedu.java.backend.PostW_s5.service.Formateador;
import org.bedu.java.backend.PostW_s5.service.Validador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PostWS5Application implements CommandLineRunner {

	private final Validador validador;
	private final Formateador formateador;
	@Autowired
	public PostWS5Application(Validador validador, Formateador formateador) {
		this.validador = validador;
		this.formateador = formateador;
	}

	public static void main(String[] args) {
		SpringApplication.run(PostWS5Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner reader = new Scanner(System.in);

		System.out.println("Introduce el nombre: ");
		String nombre = reader.nextLine();

		System.out.println("Introduce el teléfono: ");
		String telefono = reader.nextLine();

		if (validador.isValido(telefono)) {
			telefono = validador.limpiaNumero(telefono);
			telefono = formateador.formatea(telefono);

			Persona persona = new Persona(nombre, telefono);

			System.out.println(persona);
		} else {
			System.out.println("Por favor, introduce un número válido");
		}
	}

}
