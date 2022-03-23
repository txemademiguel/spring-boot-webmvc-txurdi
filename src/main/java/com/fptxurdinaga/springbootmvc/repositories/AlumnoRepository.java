package com.fptxurdinaga.springbootmvc.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fptxurdinaga.springbootmvc.domain.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
	// selecciona solo mayores de edad
	@Query("SELECT a FROM Alumnos a WHERE a.edad >= 18")
	Collection<Alumno> findAllMayoresEdad();
	
	// selecciona por nombre
	List<Alumno> findByNombre(String nombre);
	
	// selecciona mayores de una edad por nombre
	@Query("SELECT a FROM Alumnos a WHERE a.nombre = ?1 and a.edad >= ?2")
	List<Alumno> findAlumnosMayoresEdadByNombre(String nombre, Integer edad);

	// selecciona por nombre y apellidos
	List<Alumno> findByNombreAndApellidos(String nombre, String apellidos);
}
