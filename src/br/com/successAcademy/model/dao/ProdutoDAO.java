package br.com.successAcademy.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.successAcademy.model.bean.Produto;
import br.com.successAcademy.view.TelaPrincipal;

public class ProdutoDAO {
	
	public List<Produto> listar() {
		
		EntityManager em = TelaPrincipal.verificaConexao();
		
		em.getTransaction().begin();
		Query query = em.createQuery("FROM Produto produto LEFT JOIN FETCH produto.categoria");
		@SuppressWarnings("unchecked")
		List<Produto> produtos = query.getResultList();
		em.getTransaction().commit();
		
		em.close();
		
		return produtos;
	}

	public Produto consultarPorId(int id) {
	
		EntityManager em = TelaPrincipal.verificaConexao();
		Produto produto = null;
	
		produto = em.find(Produto.class, id);
	
		return produto;
	}

}
