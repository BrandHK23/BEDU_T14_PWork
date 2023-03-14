package org.bedu.java.backend.sesion4;

import org.bedu.java.backend.sesion4.modelo.Persona;
import org.bedu.java.backend.sesion4.service.FormateadorTelefonoService;
import org.bedu.java.backend.sesion4.service.ValidadorTelefonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Sesion4Application  implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(Sesion4Application.class, args);
	}
	ValidadorTelefonoService validadorTelefono;
	FormateadorTelefonoService formateadorTelefono;

	@Autowired
	public Sesion4Application(ValidadorTelefonoService validadorTelefono, FormateadorTelefonoService formateadorTelefono){
		this.validadorTelefono = validadorTelefono;
		this.formateadorTelefono = formateadorTelefono;
	}


		@Override
		public void run(String... args) throws Exception{
			Scanner reader = new Scanner (System.in);

			System.out.println("Introduce el nombre: ");
			String nombre = reader.nextLine();

			System.out.println("Introduce el teléfono: ");
			String telefono = reader.nextLine();

			if (validadorTelefono.esValido(telefono)){
				telefono = validadorTelefono.limpiarTelefono(telefono);
				telefono = formateadorTelefono.formatea(telefono);
				Persona persona = new Persona(nombre, telefono);
				System.out.println(persona);
			}else {
				System.out.println("Ingresa un numero valido!!!");
			}


		}

}
