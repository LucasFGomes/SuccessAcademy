package br.com.successAcademy.controller;

import java.util.List;

import br.com.successAcademy.model.bean.Produto;
import br.com.successAcademy.model.dao.ProdutoDAO;

public class ProdutoController {
	
	ProdutoDAO daoProduto;
	
	public ProdutoController() {
		daoProduto = new ProdutoDAO();
	}
	
	public List<Produto> listarProdutos() {
		return daoProduto.listar();
	}
	
	public Produto consultar(int id) {
		return daoProduto.consultarPorId(id);
	}

}
