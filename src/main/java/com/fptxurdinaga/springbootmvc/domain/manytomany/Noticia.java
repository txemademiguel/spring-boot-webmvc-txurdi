package com.fptxurdinaga.springbootmvc.domain.manytomany;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Noticia")
@Table(name = "NOTICIAS")
@Data
public class Noticia {
    @Id
    @GeneratedValue
    private Long id;

    private String titular;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}
    
}
