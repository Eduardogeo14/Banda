package br.edu.ifrs.banda.dominio;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Banda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@Enumerated(EnumType.STRING)
	private GeneroEnum genero;

	@OneToMany(mappedBy = "banda")
	private List<Album> albuns = new ArrayList<>();

	@OneToMany(mappedBy = "banda")
	private List<Integrante> integrantes = new ArrayList<>();

	public Banda() {
	}

	public Banda(String nome, GeneroEnum genero) {
		setNome(nome);
		this.genero = genero;
	}

	public void setNome(String nome) {
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome da banda inválido");
		}
		this.nome = nome;
	}

	public void adicionarAlbum(Album album) {
		if (album == null) {
			throw new IllegalArgumentException("Album inválido");
		}
		this.albuns.add(album);
		album.setBanda(this);
	}

	public void adicionarIntegrante(Integrante integrante) {
		if (integrante == null) {
			throw new IllegalArgumentException("Integrante inválido");
		}
		this.integrantes.add(integrante);
		integrante.setBanda(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public GeneroEnum getGenero() {
		return genero;
	}

	public void setGenero(GeneroEnum genero) {
		this.genero = genero;
	}

	public List<Album> getAlbuns() {
		return albuns;
	}

	public void setAlbuns(List<Album> albuns) {
		this.albuns = albuns;
	}

	public List<Integrante> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(List<Integrante> integrantes) {
		this.integrantes = integrantes;
	}

	@Override
	public String toString() {
		return nome + " (" + genero + ")";
	}
}