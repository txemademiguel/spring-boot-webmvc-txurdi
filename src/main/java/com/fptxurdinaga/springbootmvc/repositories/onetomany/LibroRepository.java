package com.fptxurdinaga.springbootmvc.repositories.onetomany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fptxurdinaga.springbootmvc.domain.onetomany.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {
}
