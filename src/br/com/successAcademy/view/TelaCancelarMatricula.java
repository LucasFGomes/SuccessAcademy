package br.com.successAcademy.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.successAcademy.controller.AlunoController;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCancelarMatricula extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField campoCpf;
	private JTextField campoNome;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCancelarMatricula frame = new TelaCancelarMatricula();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCancelarMatricula() {
		setClosable(true);
		setTitle("Cancelamento de Matr\u00EDcula");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		campoNome = new JTextField();
		campoNome.setColumns(10);
		campoNome.setBounds(150, 74, 142, 20);
		getContentPane().add(campoNome);
		
		JLabel lblNomeDoAluno = new JLabel("Nome do aluno");
		lblNomeDoAluno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeDoAluno.setBounds(150, 41, 108, 22);
		getContentPane().add(lblNomeDoAluno);
		
		campoCpf = new JTextField();
		campoCpf.setColumns(10);
		campoCpf.setBounds(150, 150, 102, 20);
		getContentPane().add(campoCpf);
		
		JLabel lblCpfDoAluno = new JLabel("CPF do aluno");
		lblCpfDoAluno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpfDoAluno.setBounds(150, 117, 92, 22);
		getContentPane().add(lblCpfDoAluno);
		
		JButton btnCancelarMatricula = new JButton("Cancelar Matrícula");
		btnCancelarMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelarMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AlunoController ac = new AlunoController();
				
				String nome = campoNome.getText();
				String cpf = campoCpf.getText();
				
				boolean retorno = ac.cancelarMatricula(cpf);
				
				if (retorno) {
					JOptionPane.showMessageDialog(null, nome + " excluído com sucesso!");
				}
				
			}
		});
		btnCancelarMatricula.setBounds(133, 206, 159, 28);
		getContentPane().add(btnCancelarMatricula);

	}
}
