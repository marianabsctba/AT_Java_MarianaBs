package br.edu.infnet.donationapp.model.exceptions;

public class DoadorInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public DoadorInvalidoException(String mensagem) {
		super(mensagem);
	}
}