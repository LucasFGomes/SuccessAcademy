package br.com.successAcademy.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.successAcademy.model.bean.Turma;
import br.com.successAcademy.view.TelaPrincipal;

public class TurmaDAO {

	public List<Turma> listar() {
		
		EntityManager em = TelaPrincipal.verificaConexao();
		
		em.getTransaction().begin();
		Query query = em.createQuery("FROM Turma turma LEFT JOIN FETCH turma.modalidade LEFT JOIN FETCH turma.modalidade.professor");
		@SuppressWarnings("unchecked")
		List<Turma> turmas = query.getResultList();
		em.getTransaction().commit();
		
		em.close();
		
		return turmas;
	}
	
	public Turma consultarPorId(int id) {
		
		EntityManager em = TelaPrincipal.verificaConexao();
		Turma turma = null;
		
		turma = em.find(Turma.class, id);
		
		return turma;
	}
	
}
