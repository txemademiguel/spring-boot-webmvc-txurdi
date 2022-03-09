package com.fptxurdinaga.springbootmvc.domain.onetomany;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Libro")
@Table(name = "LIBROS")
@Data
public class Libro {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "`TITLE`")
    private String title;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}

