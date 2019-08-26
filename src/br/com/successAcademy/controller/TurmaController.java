package br.com.successAcademy.controller;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

import br.com.successAcademy.model.bean.Coordenador;
import br.com.successAcademy.model.bean.Modalidade;
import br.com.successAcademy.model.bean.Professor;
import br.com.successAcademy.model.bean.Turma;
import br.com.successAcademy.model.dao.GenericoDAO;
import br.com.successAcademy.model.dao.TurmaDAO;

public class TurmaController {

	TurmaDAO daoTurma;
	GenericoDAO daoGenerico;

	public TurmaController() {
		daoTurma = new TurmaDAO();
		daoGenerico = new GenericoDAO();
	}

	public boolean cadastrarTurma(Turma turma, Professor professor, Modalidade modalidade, Coordenador coordenador) {
		
		try {
			
			daoGenerico.salvar(professor);
			daoGenerico.salvar(modalidade);
			daoGenerico.salvar(turma);
			daoGenerico.salvar(coordenador);
			
			return true;
			
		} catch (PersistenceException e) {
			JOptionPane.showMessageDialog(null, "Você não tem privilégio de admin");
			return false;
		}

	}

	public List<Turma> listarTurmas() {
		return daoTurma.listar();
	}

	public Turma consultar(int id) {
		return daoTurma.consultarPorId(id);
	}

}
