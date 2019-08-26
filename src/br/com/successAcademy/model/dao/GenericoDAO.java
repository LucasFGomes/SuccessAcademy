package br.com.successAcademy.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.com.successAcademy.view.TelaPrincipal;

public class GenericoDAO {

	public <E> void salvar(E e) throws PersistenceException {
		
			EntityManager em = TelaPrincipal.verificaConexao();

			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();

			em.close();
	
	}
	
	public <E> void atualizar(E e) throws PersistenceException {

		EntityManager em = TelaPrincipal.verificaConexao();

		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();

		em.close();
	}
	


}
