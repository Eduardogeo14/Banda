package br.edu.ifrs.banda.dominio;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;

@Entity
public class Musica {
	
	private String titulo;
	private int duracao;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Album album;
	
	public Musica() {};
	
	
	public Musica(String titulo, int duracao) {
		setTitulo(titulo);
		setDuracao(duracao);
	}
	
	public void setTitulo(String titulo) {
		if(titulo == null || titulo.trim().isEmpty()) {
			throw new IllegalArgumentException("Titulo inválido");
		} else {
			this.titulo = titulo;
		}
	}
	
	public void setDuracao(int duracao) {
		if(duracao <=0) {
			throw new IllegalArgumentException("Duração inválida");

		} else {
			this.duracao = duracao;
		}
	}
	
	// ajusta setId e getId;
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	   
	
	public Album getAlbum() {
		return this.album;
	}
	
	public void setAlbum(Album album) {
		this.album = album;
	}
	
	
}
