package com.fptxurdinaga.springbootmvc.repositories.onetomany;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fptxurdinaga.springbootmvc.domain.onetomany.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Long> {
}
