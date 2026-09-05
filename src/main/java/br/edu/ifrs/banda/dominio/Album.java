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
public class Album {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	
	
	private String titulo;
	
	@OneToMany(mappedBy = "album")
	private List<Musica> musicas = new ArrayList<Musica>();
	
	private int anoLancamento;

	
	@ManyToOne
	private Banda banda;
	
	public Album() {};
	
	
	public Album(String titulo, int anoLancamento) {
		setTitulo(titulo);
		setAnoLancamento(anoLancamento);
		
	}
	
	public void setTitulo(String titulo) {
		if(titulo == null || titulo.trim().isEmpty()) {
			throw new IllegalArgumentException("Título inválido");
		} else{
			this.titulo = titulo;
		}
	}
	
	public void setAnoLancamento(int anoLancamento) {
		if(anoLancamento <= 0) {
			throw new IllegalArgumentException("Ano inválido");
		} else {
			this.anoLancamento = anoLancamento;
		}
	}
	
	public void adicionarMusica(Musica musica) {
		if(musica == null) {
			throw new IllegalArgumentException("Musica invalida");
		} else {
			this.musicas.add(musica);
			musica.setAlbum(this);
		}
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	
	public int getAnoLancamento() {
		return anoLancamento;
	}
	
	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}
	
	
	public List<Musica> getMusicas(){
		return this.musicas;
	}
	
	public void setId(long Id) {
		this.Id=Id;
	}
	
	public void setBanda(Banda banda) {
		this.banda = banda;
	}
	
	public Banda getBanda() {
		return this.banda;
	}
}
	

