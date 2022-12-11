package br.edu.infnet.donationapp.model.exceptions;

public class TamanhoMovelInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public TamanhoMovelInvalidoException(String mensagem) {
		super(mensagem);
	}
}