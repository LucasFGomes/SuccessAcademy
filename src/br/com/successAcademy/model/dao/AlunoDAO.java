package br.com.successAcademy.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.successAcademy.model.bean.Aluno;
import br.com.successAcademy.view.TelaPrincipal;

public class AlunoDAO {

	public List<Aluno> listar() {

		EntityManager em = TelaPrincipal.verificaConexao();

		em.getTransaction().begin();
		Query query = em.createQuery("FROM Aluno aluno LEFT JOIN FETCH aluno.endereco LEFT JOIN FETCH aluno.turma");
		@SuppressWarnings("unchecked")
		List<Aluno> alunos = query.getResultList();
		em.getTransaction().commit();

		em.close();

		return alunos;
		
	}

	public Aluno consultarPorId(int id) {

		EntityManager em = TelaPrincipal.verificaConexao();
		Aluno aluno = null;

		aluno = em.find(Aluno.class, id);

		return aluno;
	}

	public boolean excluir(String cpf) {

		EntityManager em = TelaPrincipal.verificaConexao();

		em.getTransaction().begin();
		Query q = em.createNativeQuery("DELETE aluno FROM aluno WHERE cpf = " + cpf);
		q.executeUpdate();
		em.getTransaction().commit();

		em.close();

		return true;

	}

}
