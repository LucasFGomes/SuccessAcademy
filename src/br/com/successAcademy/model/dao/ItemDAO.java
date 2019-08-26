package br.com.successAcademy.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.successAcademy.model.bean.Item;
import br.com.successAcademy.view.TelaPrincipal;

public class ItemDAO {
	
	public List<Item> listar() {

		EntityManager em = TelaPrincipal.verificaConexao();

		em.getTransaction().begin();
		Query query = em.createQuery("FROM Item item LEFT JOIN FETCH item.produto LEFT JOIN FETCH item.produto.categoria");
		@SuppressWarnings("unchecked")
		List<Item> itens = query.getResultList();
		em.getTransaction().commit();

		em.close();

		return itens;
	}

}
