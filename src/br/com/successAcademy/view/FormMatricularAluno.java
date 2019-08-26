package br.com.successAcademy.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.successAcademy.controller.AlunoController;
import br.com.successAcademy.controller.TurmaController;
import br.com.successAcademy.model.bean.Aluno;
import br.com.successAcademy.model.bean.Endereco;
import br.com.successAcademy.model.bean.Telefone;
import br.com.successAcademy.model.bean.Turma;

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FormMatricularAluno extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField campoNomeAluno;
	private JTextField campoEmail;
	private JTextField campoCpfAluno;
	private JTextField campoDataNasc;
	private JTextField campoRua;
	private JTextField campoCidade;
	private JTextField campoBairro;
	private JTextField campoCep;
	private JTextField campoTelefone_1;
	private JTextField campoTelefone_2;
	private JTextField campoNumeroCasa;
	private JTable table;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMatricularAluno frame = new FormMatricularAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormMatricularAluno() {
		setTitle("Formul\u00E1rio de Matricula");
		setClosable(true);
		setResizable(true);
		setBounds(100, 100, 701, 456);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 308, 438, 107);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Turma", "Turno", "Modalidade", "Mensalidade", "Professor"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(105);
		table.getColumnModel().getColumn(4).setPreferredWidth(116);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		
		//preencher tabela de turmas
		TurmaController tc = new TurmaController();
		List<Turma> turmas = tc.listarTurmas();

		preencherTabela(turmas);
		
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(37, 23, 46, 14);
		getContentPane().add(lblNome);
		
		campoNomeAluno = new JTextField();
		campoNomeAluno.setBounds(37, 42, 259, 20);
		getContentPane().add(campoNomeAluno);
		campoNomeAluno.setColumns(10);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(37, 92, 259, 20);
		campoEmail.setColumns(10);
		getContentPane().add(campoEmail);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(37, 73, 46, 14);
		getContentPane().add(lblEmail);
		
		campoCpfAluno = new JTextField();
		campoCpfAluno.setBounds(37, 147, 128, 20);
		campoCpfAluno.setColumns(10);
		getContentPane().add(campoCpfAluno);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(37, 128, 46, 14);
		getContentPane().add(lblCpf);
		
		campoDataNasc = new JTextField();
		campoDataNasc.setBounds(37, 202, 101, 20);
		campoDataNasc.setColumns(10);
		getContentPane().add(campoDataNasc);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(37, 183, 121, 14);
		getContentPane().add(lblDataDeNascimento);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(374, 23, 46, 14);
		getContentPane().add(lblRua);
		
		campoRua = new JTextField();
		campoRua.setColumns(10);
		campoRua.setBounds(374, 42, 259, 20);
		getContentPane().add(campoRua);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(374, 73, 46, 14);
		getContentPane().add(lblCidade);
		
		campoCidade = new JTextField();
		campoCidade.setColumns(10);
		campoCidade.setBounds(374, 92, 128, 20);
		getContentPane().add(campoCidade);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(374, 128, 46, 14);
		getContentPane().add(lblBairro);
		
		campoBairro = new JTextField();
		campoBairro.setColumns(10);
		campoBairro.setBounds(374, 147, 128, 20);
		getContentPane().add(campoBairro);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(374, 183, 101, 14);
		getContentPane().add(lblCep);
		
		campoCep = new JTextField();
		campoCep.setColumns(10);
		campoCep.setBounds(374, 202, 101, 20);
		getContentPane().add(campoCep);
		
		JLabel lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setBounds(526, 183, 101, 14);
		getContentPane().add(lblNmero);
		
		campoNumeroCasa = new JTextField();
		campoNumeroCasa.setColumns(10);
		campoNumeroCasa.setBounds(526, 202, 36, 20);
		getContentPane().add(campoNumeroCasa);
		
		campoTelefone_1 = new JTextField();
		campoTelefone_1.setColumns(10);
		campoTelefone_1.setBounds(37, 263, 101, 20);
		getContentPane().add(campoTelefone_1);
		
		JLabel lblTelefone = new JLabel("1\u00BA Telefone");
		lblTelefone.setBounds(37, 244, 101, 14);
		getContentPane().add(lblTelefone);
		
		campoTelefone_2 = new JTextField();
		campoTelefone_2.setColumns(10);
		campoTelefone_2.setBounds(175, 263, 101, 20);
		getContentPane().add(campoTelefone_2);
		
		JLabel lblTelefone_1 = new JLabel("2\u00BA Telefone");
		lblTelefone_1.setBounds(175, 244, 101, 14);
		getContentPane().add(lblTelefone_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(37, 294, 438, 3);
		getContentPane().add(separator);

		JButton btnMatricularAluno = new JButton("Matricular Aluno");
		btnMatricularAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Você precisa escolher uma turma!");
				} else {
				
					AlunoController ac = new AlunoController();

					Aluno aluno = new Aluno();
					Endereco endereco = new Endereco();
					Telefone telefone_1 = new Telefone();
					Telefone telefone_2 = new Telefone();

					endereco.setRua(campoRua.getText());
					endereco.setCidade(campoCidade.getText());
					endereco.setBairro(campoBairro.getText());
					endereco.setCep(campoCep.getText());
					endereco.setNumeroCasa(Integer.parseInt(campoNumeroCasa.getText()));

					List<Telefone> fones = new ArrayList<>();

					telefone_1.setNumero(campoTelefone_1.getText());
					telefone_2.setNumero(campoTelefone_2.getText());
					
					fones.add(telefone_1);
					fones.add(telefone_2);

					aluno.setNome(campoNomeAluno.getText());
					aluno.setEmail(campoEmail.getText());
					aluno.setCpf(campoCpfAluno.getText());
					aluno.setDataNasc(campoDataNasc.getText());
					aluno.setEndereco(endereco);
					aluno.setTelefones(fones);
					
					Turma turma = tc.consultar(table.getSelectedRow() + 1);
					turma.getAlunos().add(aluno);

					boolean retorno = ac.matricular(aluno, endereco, telefone_1, telefone_2, turma);

					if (retorno) {
						JOptionPane.showMessageDialog(null, "Aluno matriculado com sucesso!");
					}
				}
			}
		});
		btnMatricularAluno.setBounds(510, 308, 142, 37);
		getContentPane().add(btnMatricularAluno);
		
		JButton btnResetar = new JButton("Resetar");
		btnResetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		btnResetar.setBounds(510, 356, 142, 37);
		getContentPane().add(btnResetar);

	}
	
	public void preencherTabela(List<Turma> turmas) {
		
		for (Turma turma : turmas) {
			((DefaultTableModel) table.getModel()).addRow(
					new Object[] {
							turma.getId(),
							turma.getNome(),
							turma.getTurno(),
							turma.getModalidade().getNome(),
							turma.getModalidade().getPrecoMensalidade(),
							turma.getModalidade().getProfessor().getNome()
					}
				);
		}
		
	}
	
	public void limparCampos() {
		campoNomeAluno.setText(null);
		campoEmail.setText(null);
		campoCpfAluno.setText(null);
		campoDataNasc.setText(null);
		campoRua.setText(null);
		campoCidade.setText(null);
		campoBairro.setText(null);
		campoCep.setText(null);
		campoTelefone_1.setText(null);
		campoTelefone_2.setText(null);
		campoNumeroCasa.setText(null);
	}
}
