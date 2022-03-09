package com.fptxurdinaga.springbootmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fptxurdinaga.springbootmvc.domain.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

}
