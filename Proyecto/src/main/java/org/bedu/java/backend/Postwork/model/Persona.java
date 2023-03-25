package org.bedu.java.backend.Postwork.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Entity
@Table(name = "PERSONAS")
public class Persona implements Comparable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo no puede estar vacio")
    private String nombre;
    @Column(nullable = false, length = 100)


    @Pattern(regexp ="^(\\d{2,4}[- .]?){2}\\d{4}$", message = "Formato de teléfono no valido")
    private String telefono;
    @Column(nullable = false, length = 20)


    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o==null || getClass() != o.getClass())return false;
        Persona persona=(Persona) o;
        return nombre.equals(persona.nombre);
    }
    @Override
    public int hashCode(){
        return Objects.hash(nombre);
    }

    @Override
    public int compareTo(Object o){
        Persona other = (Persona) o;
        return this.nombre.compareTo(other.nombre);
    }
}