package br.com.successAcademy.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.com.successAcademy.controller.TurmaController;
import br.com.successAcademy.model.bean.Turma;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListagemTurmas extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemTurmas frame = new TelaListagemTurmas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	List<Turma> turmas;

	public TelaListagemTurmas() {
		setTitle("Listagem de Turmas");
		setClosable(true);
		setBounds(100, 100, 695, 396);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 659, 280);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome_Turma", "Turno", "Nome_Modalidade", "Mensalidade", "Quant_Vagas", "Nome_Professor"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(28);
		table.getColumnModel().getColumn(1).setPreferredWidth(82);
		table.getColumnModel().getColumn(2).setPreferredWidth(58);
		table.getColumnModel().getColumn(3).setPreferredWidth(103);
		table.getColumnModel().getColumn(5).setPreferredWidth(86);
		table.getColumnModel().getColumn(6).setPreferredWidth(93);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Faturamento Mensal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (table.getSelectedRow() != -1) {
					
					TurmaController tc = new TurmaController();
					Turma turma = tc.consultar(table.getSelectedRow() + 1);
					
					double precoMensalidade = turma.getModalidade().getPrecoMensalidade();
					int quantALunos = turma.getAlunos().size();
					
					double resultado = precoMensalidade * quantALunos;
					
					JOptionPane.showMessageDialog(null, "O Faturamento mensal dessa turma é R$" + resultado);
				}
				
			}
		});
		btnNewButton.setBounds(253, 303, 170, 39);
		getContentPane().add(btnNewButton);
		
		TurmaController turmaController = new TurmaController();
		
		turmas = turmaController.listarTurmas();
		
		preencheTabela(turmas);

	}
	
	public void preencheTabela(List<Turma> turmas) {
		
		for (Turma turma : turmas) {
			
			((DefaultTableModel) table.getModel()).addRow(
					new Object[] {
							turma.getId(),
							turma.getNome(),
							turma.getTurno(),
							turma.getModalidade().getNome(),
							turma.getModalidade().getPrecoMensalidade(),
							turma.getModalidade().getQuantVagas(),
							turma.getModalidade().getProfessor().getNome()
					}
				);
			
		}
		
	}
}
