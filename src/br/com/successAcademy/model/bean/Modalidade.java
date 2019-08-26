package br.com.successAcademy.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "modalidade")
public class Modalidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nome;
	@Column
	private int quantVagas;
	@Column
	private double precoMensalidade;
	@OneToOne
	@JoinColumn(name = "id_professor")
	private Professor professor;
	@OneToOne(mappedBy = "modalidade")
	private Turma turma;
	
	public Modalidade() {
	}

	public Modalidade(String nome, int quantVagas, double precoMensalidade, Professor professor) {
		this.nome = nome;
		this.quantVagas = quantVagas;
		this.precoMensalidade = precoMensalidade;
		this.professor = professor;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantVagas() {
		return quantVagas;
	}

	public void setQuantVagas(int quantVagas) {
		this.quantVagas = quantVagas;
	}

	public double getPrecoMensalidade() {
		return precoMensalidade;
	}

	public void setPrecoMensalidade(double precoMensalidade) {
		this.precoMensalidade = precoMensalidade;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
}
