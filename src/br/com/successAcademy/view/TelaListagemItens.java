package br.com.successAcademy.view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.successAcademy.controller.ItemController;
import br.com.successAcademy.model.bean.Item;

public class TelaListagemItens extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemItens frame = new TelaListagemItens();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaListagemItens() {
		setTitle("Listagem de Itens");
		setClosable(true);
		setBounds(100, 100, 567, 416);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 531, 364);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Pre\u00E7o", "Quantidade", "Produto", "Valor_Unit\u00E1rio", "Categoria"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(37);
		table.getColumnModel().getColumn(2).setPreferredWidth(91);
		table.getColumnModel().getColumn(3).setPreferredWidth(86);
		table.getColumnModel().getColumn(4).setPreferredWidth(103);
		scrollPane.setViewportView(table);
		
		ItemController itemController = new ItemController();
		
		List<Item> itens = itemController.listarItens();
		
		preencheTabela(itens);

	}
	
	public void preencheTabela(List<Item> itens) {
		
		for (Item item : itens) {
			((DefaultTableModel) table.getModel()).addRow(
					new Object[] {
							item.getId(),
							item.getPreco(),
							item.getQuantidade(),
							item.getProduto().getNome(),
							item.getProduto().getValorUnitario(),
							item.getProduto().getCategoria().getDescricao()
							
					}
				);
		}
		
	}
	
	

}
