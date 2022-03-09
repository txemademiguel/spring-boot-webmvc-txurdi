package com.fptxurdinaga.springbootmvc.domain;


import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Persona {
    private Long id;
    @Size(min = 3, max = 20, message = "el nombre debe tener mas de 3 letras y menos de 20.")
    private String nombre;

    private String apellidos;

    @Min(value = 18, message = "el usuario debe tener 18+")
    private  Integer edad;
    public Persona() {
        super();
        this.id = 0L;
        this.nombre = "";
        this.apellidos = "";
        this.edad = 0;
    }
    public Persona(Long id, String nombre, String apellidos, Integer edad) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
