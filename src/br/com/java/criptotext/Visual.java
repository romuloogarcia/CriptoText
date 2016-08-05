package br.com.java.criptotext;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Visual extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea txtTexto;
	private JButton btnDecriptar;
	private JButton btnEncriptar;

	/**
	 * Create the frame.
	 */
	public Visual() {
		setBackground(Color.WHITE);
		setTitle("Sistema de Criptografia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);

		txtTexto = new JTextArea();
		contentPane.add(txtTexto, BorderLayout.CENTER);

		btnDecriptar = new JButton("Decriptar");
		btnDecriptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String texto = txtTexto.getText();
				txtTexto.setText(CriptoText.decripta(texto));
			}
		});
		contentPane.add(btnDecriptar, BorderLayout.SOUTH);

		btnEncriptar = new JButton("Encriptar");
		btnEncriptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String texto = txtTexto.getText();
				txtTexto.setText(CriptoText.encripta(texto));
			}
		});
		contentPane.add(btnEncriptar, BorderLayout.NORTH);
	}

}
