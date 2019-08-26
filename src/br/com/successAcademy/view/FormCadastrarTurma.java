package br.com.successAcademy.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.successAcademy.controller.TurmaController;
import br.com.successAcademy.model.bean.Coordenador;
import br.com.successAcademy.model.bean.Modalidade;
import br.com.successAcademy.model.bean.Professor;
import br.com.successAcademy.model.bean.Turma;

import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class FormCadastrarTurma extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField campoNomeTurma;
	private JTextField campoTurno;
	private JTextField campoNomeModalidade;
	private JTextField campoMensalidade;
	private JTextField campoQuantVagas;
	private JTextField campoCpfProfessor;
	private JTextField campoNomeProfessor;
	private JTextField campoTitulacaoProfessor;
	private JTextField campoCpfCoordenador;
	private JTextField campoNomeCoordenador;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCadastrarTurma frame = new FormCadastrarTurma();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormCadastrarTurma() {
		setTitle("Cadastro de Turma");
		setClosable(true);
		setBounds(100, 100, 589, 416);
		getContentPane().setLayout(null);
		
		JLabel lblNomeDaTurma = new JLabel("Nome da Turma");
		lblNomeDaTurma.setBounds(31, 38, 116, 14);
		getContentPane().add(lblNomeDaTurma);
		
		campoNomeTurma = new JTextField();
		campoNomeTurma.setBounds(31, 63, 129, 20);
		getContentPane().add(campoNomeTurma);
		campoNomeTurma.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Turno");
		lblNewLabel.setBounds(31, 111, 46, 14);
		getContentPane().add(lblNewLabel);
		
		campoTurno = new JTextField();
		campoTurno.setBounds(31, 136, 86, 20);
		getContentPane().add(campoTurno);
		campoTurno.setColumns(10);
		
		campoNomeModalidade = new JTextField();
		campoNomeModalidade.setColumns(10);
		campoNomeModalidade.setBounds(216, 63, 129, 20);
		getContentPane().add(campoNomeModalidade);
		
		JLabel lblNomeDaModalidade = new JLabel("Nome da Modalidade");
		lblNomeDaModalidade.setBounds(216, 38, 136, 14);
		getContentPane().add(lblNomeDaModalidade);
		
		campoMensalidade = new JTextField();
		campoMensalidade.setColumns(10);
		campoMensalidade.setBounds(216, 136, 86, 20);
		getContentPane().add(campoMensalidade);
		
		JLabel lblMensalidade = new JLabel("Mensalidade");
		lblMensalidade.setBounds(216, 111, 87, 14);
		getContentPane().add(lblMensalidade);
		
		campoQuantVagas = new JTextField();
		campoQuantVagas.setColumns(10);
		campoQuantVagas.setBounds(216, 202, 29, 20);
		getContentPane().add(campoQuantVagas);
		
		JLabel lblQuantidadeDeVagas = new JLabel("Quantidade de Vagas");
		lblQuantidadeDeVagas.setBounds(216, 177, 136, 14);
		getContentPane().add(lblQuantidadeDeVagas);
		
		campoCpfProfessor = new JTextField();
		campoCpfProfessor.setColumns(10);
		campoCpfProfessor.setBounds(406, 136, 116, 20);
		getContentPane().add(campoCpfProfessor);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(406, 111, 46, 14);
		getContentPane().add(lblCpf);
		
		campoNomeProfessor = new JTextField();
		campoNomeProfessor.setColumns(10);
		campoNomeProfessor.setBounds(406, 63, 129, 20);
		getContentPane().add(campoNomeProfessor);
		
		JLabel lblNomeDoProfessor = new JLabel("Nome do Professor");
		lblNomeDoProfessor.setBounds(406, 38, 116, 14);
		getContentPane().add(lblNomeDoProfessor);
		
		campoTitulacaoProfessor = new JTextField();
		campoTitulacaoProfessor.setColumns(10);
		campoTitulacaoProfessor.setBounds(406, 202, 116, 20);
		getContentPane().add(campoTitulacaoProfessor);
		
		JLabel lblTitulaoDoProfessor = new JLabel("Titula\u00E7\u00E3o do Professor");
		lblTitulaoDoProfessor.setBounds(406, 177, 136, 14);
		getContentPane().add(lblTitulaoDoProfessor);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 250, 491, 2);
		getContentPane().add(separator);
		
		campoCpfCoordenador = new JTextField();
		campoCpfCoordenador.setColumns(10);
		campoCpfCoordenador.setBounds(31, 344, 116, 20);
		getContentPane().add(campoCpfCoordenador);
		
		JLabel label = new JLabel("CPF");
		label.setBounds(31, 319, 46, 14);
		getContentPane().add(label);
		
		campoNomeCoordenador = new JTextField();
		campoNomeCoordenador.setColumns(10);
		campoNomeCoordenador.setBounds(31, 288, 129, 20);
		getContentPane().add(campoNomeCoordenador);
		
		JLabel lblNomeDoCoordenador = new JLabel("Nome do Coordenador");
		lblNomeDoCoordenador.setBounds(31, 263, 154, 14);
		getContentPane().add(lblNomeDoCoordenador);
		
		JButton btnCadastrarTurma = new JButton("Cadastrar Turma");
		btnCadastrarTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Turma turma = new Turma();
				Modalidade modalidade = new Modalidade();
				Professor professor = new Professor();
				Coordenador coordenador = new Coordenador();
				
				TurmaController turmaController = new TurmaController();
				
				List<Turma> turmas = new ArrayList<Turma>();
				
				professor.setNome(campoNomeProfessor.getText());
				professor.setCpf(campoCpfProfessor.getText());
				professor.setTitulacao(campoTitulacaoProfessor.getText());
				
				turma.setNome(campoNomeTurma.getText());
				turma.setTurno(campoTurno.getText());
				
				modalidade.setNome(campoNomeModalidade.getText());
				modalidade.setPrecoMensalidade(Double.parseDouble(campoMensalidade.getText()));
				modalidade.setQuantVagas(Integer.parseInt(campoQuantVagas.getText()));
				
				coordenador.setNome(campoNomeCoordenador.getText());
				coordenador.setCpf(campoCpfCoordenador.getText());
				
				turmas.add(turma);
		
				coordenador.setTurmas(turmas);
				
				turma.setModalidade(modalidade);
				modalidade.setProfessor(professor);
				
				boolean retorno = turmaController.cadastrarTurma(turma, professor, modalidade, coordenador);
				
				if (retorno) {
					JOptionPane.showMessageDialog(null, "Turma criada com sucesso!");
				}
				
			}
		});
		btnCadastrarTurma.setBounds(236, 310, 136, 33);
		getContentPane().add(btnCadastrarTurma);
		
		JButton btnResetar = new JButton("Resetar");
		btnResetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnResetar.setBounds(382, 310, 116, 33);
		getContentPane().add(btnResetar);

	}
	
	public void limparCampos() {
		campoNomeTurma.setText(null);
		campoTurno.setText(null);
		campoNomeModalidade.setText(null);
		campoMensalidade.setText(null);
		campoQuantVagas.setText(null);
		campoNomeProfessor.setText(null);
		campoCpfProfessor.setText(null);
		campoTitulacaoProfessor.setText(null);
		campoNomeCoordenador.setText(null);
		campoCpfCoordenador.setText(null);
		
	}
}
