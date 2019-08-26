package br.com.successAcademy.view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.successAcademy.controller.AlunoController;
import br.com.successAcademy.model.bean.Aluno;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

public class TelaListagemAlunos extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemAlunos frame = new TelaListagemAlunos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	List<Aluno> alunos;
	private JTable table;

	public TelaListagemAlunos() {
		setTitle("Listagem de Alunos");
		setClosable(true);
		setBounds(100, 100, 800, 500);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "E-mail", "CPF", "DataNasc", "Rua", "Cidade", "Bairro", "CEP", "N\u00BA"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(67);
		table.getColumnModel().getColumn(2).setPreferredWidth(105);
		table.getColumnModel().getColumn(3).setPreferredWidth(85);
		table.getColumnModel().getColumn(4).setPreferredWidth(67);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(9).setPreferredWidth(31);
		scrollPane.setViewportView(table);
		
		AlunoController ac = new AlunoController();
		
		alunos = ac.listarAlunos();
		
		preencherTabela(alunos);
	
	}
	
	public void preencherTabela(List<Aluno> alunos) {
		
		for (Aluno aluno : alunos) {
			((DefaultTableModel) table.getModel()).addRow(
						new Object[] {
								aluno.getId(),
								aluno.getNome(),
								aluno.getEmail(),
								aluno.getCpf(),
								aluno.getDataNasc(),
								aluno.getEndereco().getRua(),
								aluno.getEndereco().getCidade(),
								aluno.getEndereco().getBairro(),
								aluno.getEndereco().getCep(),
								aluno.getEndereco().getNumeroCasa()
						}
					);
		}
		
	}
	
}
