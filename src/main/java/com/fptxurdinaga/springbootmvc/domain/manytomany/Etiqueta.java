package com.fptxurdinaga.springbootmvc.domain.manytomany;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Etiqueta")
@Table(name = "ETIQUETAS")
@Data
public class Etiqueta {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    @ManyToMany(cascade =
            {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Noticia> noticias = new ArrayList<Noticia>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Noticia> getNoticias() {
		return noticias;
	}
	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
    
}
