package br.com.java.criptotext;

import java.awt.EventQueue;

/**
 * Sistema para encriptação.
 * 
 * @author romulo.garcia
 * @since 01/12/2015
 */
public class CriptoText {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				Visual vs = new Visual();
				vs.setVisible(true);

			}
		});
	}

	private static int pulos = 20;

	/**
	 * Método de encriptação.
	 * 
	 * @param senha
	 *            String informando uma string em texto plano.
	 * @return String String contendo uma senha encriptada.
	 */
	private static StringBuilder encode(String senha) {
		StringBuilder sb = new StringBuilder();
		sb.append(senha);
		char[] arraySenha = new char[sb.length()];
		arraySenha = sb.toString().toCharArray();
		char[] parteA = sb.substring(0, arraySenha.length / 2).toCharArray();
		char[] parteB = sb.substring(arraySenha.length / 2).toCharArray();
		for (int i = 0; i < parteA.length; i++) {
			parteA[i] = (char) (parteA[i] + pulos);
		}
		for (int i = 0; i < parteB.length; i++) {
			parteB[i] = (char) (parteB[i] - pulos);
		}
		StringBuilder sbFinal = new StringBuilder();
		sbFinal.append(parteA);
		sbFinal.append(parteB);
		sbFinal.reverse();
		return sbFinal;
	}

	/**
	 * Método de decriptação
	 * 
	 * @param senha
	 *            String informando uma string encriptada.
	 * @return String String contendo uma senha decriptada.
	 */
	private static StringBuilder decode(String senha) {
		StringBuilder sb = new StringBuilder();
		sb.append(senha);
		sb.reverse();
		char[] arraySenha = new char[sb.length()];
		arraySenha = sb.toString().toCharArray();
		char[] parteA = sb.substring(0, arraySenha.length / 2).toCharArray();
		char[] parteB = sb.substring(arraySenha.length / 2).toCharArray();
		for (int i = 0; i < parteA.length; i++) {
			parteA[i] = (char) (parteA[i] - pulos);
		}
		for (int i = 0; i < parteB.length; i++) {
			parteB[i] = (char) (parteB[i] + pulos);
		}
		StringBuilder sbFinal = new StringBuilder();
		sbFinal.append(parteA);
		sbFinal.append(parteB);
		return sbFinal;
	}

	/**
	 * Método para encriptar a senha.
	 * 
	 * @param pass
	 *            Senha decriptada passada por parâmetro.
	 * @return String Senha encriptada.
	 */
	public static String encripta(String pass) {
		StringBuilder senha = encode(pass);
		return senha.toString();
	}

	/**
	 * Método para desencriptar a senha.
	 * 
	 * @param pass
	 *            Senha encriptada passada por parâmetro.
	 * @return String Senha decriptada.
	 */
	public static String decripta(String pass) {
		StringBuilder senha = decode(pass);
		return senha.toString();
	}
}