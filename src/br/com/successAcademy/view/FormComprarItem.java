package br.com.successAcademy.view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.successAcademy.controller.AlunoController;
import br.com.successAcademy.controller.ItemController;
import br.com.successAcademy.controller.ProdutoController;
import br.com.successAcademy.model.bean.Aluno;
import br.com.successAcademy.model.bean.Item;
import br.com.successAcademy.model.bean.Produto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormComprarItem extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField campoQuantItem;
	private JTable table;
	private JTable table_alunos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormComprarItem frame = new FormComprarItem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormComprarItem() {
		setTitle("Comprar Itens");
		setClosable(true);
		setBounds(100, 100, 543, 447);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Quantidade do Item");
		lblNewLabel.setBounds(45, 11, 150, 14);
		getContentPane().add(lblNewLabel);

		campoQuantItem = new JTextField();
		campoQuantItem.setBounds(45, 36, 40, 20);
		getContentPane().add(campoQuantItem);
		campoQuantItem.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(45, 67, 397, 2);
		getContentPane().add(separator);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 80, 446, 102);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Produto", "Valor_Unit\u00E1rio", "Categoria" }));
		table.getColumnModel().getColumn(2).setPreferredWidth(115);
		table.getColumnModel().getColumn(3).setPreferredWidth(86);
		scrollPane.setViewportView(table);

		ProdutoController produtoController = new ProdutoController();

		List<Produto> produtos = produtoController.listarProdutos();

		preencherTabela(produtos);

		JButton btnComprarItem = new JButton("Comprar Item");
		btnComprarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() == -1 && table_alunos.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Você precisa selecionar o aluno e/ou o produto!");
				} 
				
				AlunoController alunoController = new AlunoController();
				ProdutoController produtoController = new ProdutoController();
				ItemController itemController = new ItemController();

				Produto produto = produtoController.consultar(table.getSelectedRow() + 1);
				Aluno aluno = alunoController.consultar(table_alunos.getSelectedRow() + 1);

				int quantidade = Integer.parseInt(campoQuantItem.getText());

				Item item = new Item();
				item.setQuantidade(quantidade);
				item.setPreco(quantidade * produto.getValorUnitario());
				item.setProduto(produto);

				List<Item> itens = new ArrayList<>();
				itens.add(item);

				aluno.setItens(itens);

				boolean retorno = itemController.comprar(produto, item, aluno);

				if (retorno) {
					JOptionPane.showMessageDialog(null, "Item comprado com sucesso!");
				}

			}
		});
		btnComprarItem.setBounds(181, 372, 140, 34);
		getContentPane().add(btnComprarItem);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(45, 206, 446, 139);
		getContentPane().add(scrollPane_1);

		table_alunos = new JTable();
		table_alunos.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "E-mail", "Nome", "CPF_Aluno" }));
		table_alunos.getColumnModel().getColumn(0).setPreferredWidth(32);
		table_alunos.getColumnModel().getColumn(1).setPreferredWidth(174);
		table_alunos.getColumnModel().getColumn(2).setPreferredWidth(80);
		table_alunos.getColumnModel().getColumn(3).setPreferredWidth(133);
		scrollPane_1.setViewportView(table_alunos);

		AlunoController alunoController = new AlunoController();
		List<Aluno> alunos = alunoController.listarAlunos();

		preencherTabelaAlunos(alunos);

	}

	public void preencherTabela(List<Produto> produtos) {

		for (Produto produto : produtos) {
			((DefaultTableModel) table.getModel()).addRow(new Object[] { produto.getId(), produto.getNome(),
					produto.getValorUnitario(), produto.getCategoria().getDescricao() });
		}

	}

	public void preencherTabelaAlunos(List<Aluno> alunos) {

		for (Aluno aluno : alunos) {
			((DefaultTableModel) table_alunos.getModel())
					.addRow(new Object[] { aluno.getId(), aluno.getEmail(), aluno.getNome(), aluno.getCpf() });
		}

	}
}
