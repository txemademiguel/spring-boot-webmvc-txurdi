package com.fptxurdinaga.springbootmvc.dto;

import com.fptxurdinaga.springbootmvc.domain.Alumno;

import lombok.Data;

@Data
public class AlumnoDevuelto {
    private Boolean error;
    private String message;
    private Alumno alumno;
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
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
}
