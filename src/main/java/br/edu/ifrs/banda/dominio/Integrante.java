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
public class Integrante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@ManyToOne
	private Banda banda;

	public Integrante() {
	}

	public Integrante(String nome) {
		setNome(nome);
	}

	public void setNome(String nome) {
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome do integrante inválido");
		} else {
			this.nome = nome;
		}
	}

	public String getNome() {
		return this.nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public Banda getBanda() {
		return this.banda;
	}

}
