package br.com.successAcademy.controller;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

import br.com.successAcademy.model.bean.Aluno;
import br.com.successAcademy.model.bean.Item;
import br.com.successAcademy.model.bean.Produto;
import br.com.successAcademy.model.dao.GenericoDAO;
import br.com.successAcademy.model.dao.ItemDAO;

public class ItemController {
	
	GenericoDAO daoGenerico;
	ItemDAO daoItem;
	
	public ItemController() {
		daoGenerico = new GenericoDAO();
		daoItem = new ItemDAO();
	}
	
	public boolean comprar(Produto produto, Item item, Aluno aluno) {
		
		try {
			
			daoGenerico.atualizar(produto);
			daoGenerico.salvar(item);
			daoGenerico.atualizar(aluno);
		
			return true;
		
		} catch (PersistenceException e) {
			JOptionPane.showMessageDialog(null, "Você não tem privilégio de admin");
			return false;
		}
	}
	
	public List<Item> listarItens() {
		return daoItem.listar();
	}

}
