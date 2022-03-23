package com.fptxurdinaga.springbootmvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fptxurdinaga.springbootmvc.domain.Alumno;
import com.fptxurdinaga.springbootmvc.repositories.AlumnoRepository;

import java.util.Collection;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;
    public Alumno getFirstByCosas(String nombre, Integer edad){
        Collection<Alumno> listado = this.alumnoRepository.findAlumnosMayoresEdadByNombre(nombre,edad);
        return (Alumno) listado.toArray()[0];
    }
}
