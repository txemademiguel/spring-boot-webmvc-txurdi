package com.fptxurdinaga.springbootmvc.repositories.manytomany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fptxurdinaga.springbootmvc.domain.manytomany.Noticia;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia,Long> {
}
