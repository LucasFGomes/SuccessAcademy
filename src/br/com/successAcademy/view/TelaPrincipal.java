package br.com.successAcademy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.successAcademy.connection.ConnectionFactory;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.persistence.EntityManager;
import javax.swing.ImageIcon;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static boolean isAdmin = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPrincipal() {
		setResizable(false);
		setTitle("Success Academy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane areaTrabalho = new JDesktopPane();
		contentPane.add(areaTrabalho, BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 838, 21);
		areaTrabalho.add(menuBar);

		JMenu mnAlunos = new JMenu("Alunos");
		menuBar.add(mnAlunos);

		JMenuItem mntmMatricular = new JMenuItem("Matricular");
		mntmMatricular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				FormMatricularAluno formMatriculaAluno = new FormMatricularAluno();
				areaTrabalho.add(formMatriculaAluno);
				formMatriculaAluno.setVisible(true);

			}
		});
		mnAlunos.add(mntmMatricular);

		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				TelaListagemAlunos listagemAlunos = new TelaListagemAlunos();
				areaTrabalho.add(listagemAlunos);
				listagemAlunos.setVisible(true);

			}
		});
		mnAlunos.add(mntmListar);

		JMenuItem mntmCancelarMatrcula = new JMenuItem("Cancelar Matr\u00EDcula");
		mntmCancelarMatrcula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaCancelarMatricula telaCancelarMatricula = new TelaCancelarMatricula();
				areaTrabalho.add(telaCancelarMatricula);
				telaCancelarMatricula.setVisible(true);
			}
		});
		mnAlunos.add(mntmCancelarMatrcula);

		JMenu mnTurmas = new JMenu("Turmas");
		menuBar.add(mnTurmas);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FormCadastrarTurma formCadastroTurma = new FormCadastrarTurma();
				areaTrabalho.add(formCadastroTurma);
				formCadastroTurma.setVisible(true);
				
			}
		});
		mnTurmas.add(mntmCadastrar);
		
		JMenuItem mntmListar_1 = new JMenuItem("Listar");
		mntmListar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaListagemTurmas listagemTurmas = new TelaListagemTurmas();
				areaTrabalho.add(listagemTurmas);
				listagemTurmas.setVisible(true);
				
			}
		});
		mnTurmas.add(mntmListar_1);
		
		JMenu mnItens = new JMenu("Itens");
		menuBar.add(mnItens);
		
		JMenuItem mntmComprar = new JMenuItem("Comprar");
		mntmComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FormComprarItem formComprarItem = new FormComprarItem();
				areaTrabalho.add(formComprarItem);
				formComprarItem.setVisible(true);
				
			}
		});
		mnItens.add(mntmComprar);
		
		JMenuItem mntmListaDeItens = new JMenuItem("Lista de Itens");
		mntmListaDeItens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaListagemItens listagemItens = new TelaListagemItens();
				areaTrabalho.add(listagemItens);
				listagemItens.setVisible(true);
				
			}
		});
		mnItens.add(mntmListaDeItens);

		JMenu mnTrocarUsurio = new JMenu("Trocar Usu\u00E1rio");
		menuBar.add(mnTrocarUsurio);

		JMenuItem mntmAdmin = new JMenuItem("Admin");
		mntmAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isAdmin = true;
				JOptionPane.showMessageDialog(null, "Admin entrou no sistema");
			}
		});
		mnTrocarUsurio.add(mntmAdmin);

		JMenuItem mntmUsurio = new JMenuItem("Usu\u00E1rio");
		mntmUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isAdmin = false;
				JOptionPane.showMessageDialog(null, "Usuario comum entrou no sistema");
			}
		});
		mnTrocarUsurio.add(mntmUsurio);

		JLabel labelBackground = new JLabel("");
		labelBackground.setIcon(
				new ImageIcon("D:\\Meus Documentos\\Documentos\\workspace\\SuccessAcademy\\img\\2420476-large.jpg"));
		labelBackground.setBounds(57, 73, 732, 434);
		areaTrabalho.add(labelBackground);

	}

	public static EntityManager verificaConexao() {
		if (isAdmin) {
			return ConnectionFactory.getEntityManager();
		}
		return ConnectionFactory.getEntityManagerLeitura();
	}
}
