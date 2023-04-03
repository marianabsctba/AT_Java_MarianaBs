package br.edu.infnet.donationapp.model.exceptions;

public class ValidadeAlimentoInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ValidadeAlimentoInvalidoException(String mensagem) {
		super(mensagem);
	}
}