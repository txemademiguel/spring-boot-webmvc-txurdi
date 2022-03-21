package com.fptxurdinaga.springbootmvc.dto;

import lombok.Data;
import java.util.List;

import com.fptxurdinaga.springbootmvc.domain.Alumno;

@Data
public class ListadoAlumnoDevuelto {
    private Boolean error;
    private String message;
    private List<Alumno> alumnos;
	public Boolean getError() {
		return error;
	}
	public void setError(Boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
}
