package br.com.successAcademy.controller;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

import br.com.successAcademy.model.bean.Aluno;
import br.com.successAcademy.model.bean.Endereco;
import br.com.successAcademy.model.bean.Telefone;
import br.com.successAcademy.model.bean.Turma;
import br.com.successAcademy.model.dao.AlunoDAO;
import br.com.successAcademy.model.dao.GenericoDAO;

public class AlunoController {
	
	GenericoDAO daoGenerico;
	AlunoDAO daoAluno;
	
	public AlunoController() {
		daoGenerico = new GenericoDAO();
		daoAluno = new AlunoDAO();
	}
	
	public boolean matricular(Aluno aluno, Endereco endereco, Telefone telefone_1, Telefone telefone_2, Turma turma) {
		
		try {
			
			daoGenerico.salvar(endereco);
			daoGenerico.salvar(telefone_1);
			daoGenerico.salvar(telefone_2);
			daoGenerico.salvar(aluno);
			daoGenerico.atualizar(turma);
			
			return true;
			
		} catch (PersistenceException e) {
			JOptionPane.showMessageDialog(null, "Você não tem privilégio de admin");
			return false;
		}
		
	}
	
	public List<Aluno> listarAlunos() {
		return daoAluno.listar();
	}
	
	public Aluno consultar(int id) {
		return daoAluno.consultarPorId(id);
	}
	
	public boolean cancelarMatricula(String cpf) {
		return daoAluno.excluir(cpf);
	}


}
