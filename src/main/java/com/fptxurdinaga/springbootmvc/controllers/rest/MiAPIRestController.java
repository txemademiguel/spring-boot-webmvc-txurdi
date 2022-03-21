package com.fptxurdinaga.springbootmvc.controllers.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fptxurdinaga.springbootmvc.domain.Alumno;
import com.fptxurdinaga.springbootmvc.dto.AlumnoDevuelto;
import com.fptxurdinaga.springbootmvc.dto.AlumnoSinID;
import com.fptxurdinaga.springbootmvc.dto.ListadoAlumnoDevuelto;
import com.fptxurdinaga.springbootmvc.repositories.AlumnoRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/alumno")
public class MiAPIRestController {
    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping()
    public ListadoAlumnoDevuelto index(){
        ListadoAlumnoDevuelto listadoAlumnoDevuelto = new ListadoAlumnoDevuelto();
        List<Alumno> listado = alumnoRepository.findAll();
        listadoAlumnoDevuelto.setError(false);
        listadoAlumnoDevuelto.setMessage("Alumnos finded!");
        listadoAlumnoDevuelto.setAlumnos(listado);
        return listadoAlumnoDevuelto;
    }
    @PostMapping()
    public AlumnoDevuelto insert(@Valid @RequestBody AlumnoSinID alumnoSinID){
        Alumno alumno = new Alumno();
        alumno.setEdad(alumnoSinID.getEdad());
        alumno.setNombre(alumnoSinID.getNombre());
        alumno.setApellidos(alumnoSinID.getApellidos());
        alumnoRepository.save(alumno);
        AlumnoDevuelto alumnoDevuelto = new AlumnoDevuelto();
        alumnoDevuelto.setError(false);
        alumnoDevuelto.setMessage("Alumnno inserted");
        alumnoDevuelto.setAlumno(alumno);
        return alumnoDevuelto;
    }
    @GetMapping("/{id}")
    public AlumnoDevuelto showById(@PathVariable("id") Long id){
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(id);
        AlumnoDevuelto alumnoDevuelto = new AlumnoDevuelto();
        if (alumnoOptional.isPresent()){
            alumnoDevuelto.setError(false);
            alumnoDevuelto.setMessage("Alumno retreived");
            alumnoDevuelto.setAlumno(alumnoOptional.get());
        }else{
            alumnoDevuelto.setError(true);
            alumnoDevuelto.setMessage("Alumnos not found, incorrect ID");
        }
        return alumnoDevuelto;
    }
    @PutMapping("/{id}")
    public AlumnoDevuelto editById(
            @PathVariable("id") Long id,
            @Valid @RequestBody AlumnoSinID alumnoSinID
            ) {
        AlumnoDevuelto alumnoDevuelto = new AlumnoDevuelto();
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(id);
        if (alumnoOptional.isPresent()){
            Alumno alumno = new Alumno();
            alumno.setId(id);
            alumno.setEdad(alumnoSinID.getEdad());
            alumno.setNombre(alumnoSinID.getNombre());
            alumno.setApellidos(alumnoSinID.getApellidos());
            alumnoRepository.save(alumno);
            alumnoDevuelto.setError(false);
            alumnoDevuelto.setMessage("Alumno updated");
            alumnoDevuelto.setAlumno(alumno);
        }else {
            alumnoDevuelto.setError(true);
            alumnoDevuelto.setMessage("Alumno not found, incorrect ID");
        }
        return alumnoDevuelto;
    }
    @DeleteMapping("/{id}")
    public AlumnoDevuelto deleteById(@PathVariable("id") Long id){
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(id);
        AlumnoDevuelto alumnoDevuelto = new AlumnoDevuelto();
        if (alumnoOptional.isPresent()){
            alumnoRepository.delete(alumnoOptional.get());
            alumnoDevuelto.setError(false);
            alumnoDevuelto.setMessage("Alumno deleted");
            alumnoDevuelto.setAlumno(alumnoOptional.get());
        }else{
            alumnoDevuelto.setError(true);
            alumnoDevuelto.setMessage("Alumnos not found, incorrect ID");
        }
        return alumnoDevuelto;
    }

}
