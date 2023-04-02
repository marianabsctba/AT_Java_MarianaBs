package br.edu.infnet.donationapp.model.exceptions;

public class TamanhoVestuarioInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public TamanhoVestuarioInvalidoException(String mensagem) {
		super(mensagem);
	}
}