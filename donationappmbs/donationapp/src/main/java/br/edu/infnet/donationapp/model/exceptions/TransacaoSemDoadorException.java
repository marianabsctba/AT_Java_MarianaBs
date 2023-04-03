package br.edu.infnet.donationapp.model.exceptions;

public class TransacaoSemDoadorException extends Exception {

	private static final long serialVersionUID = 1L;

	public TransacaoSemDoadorException(String mensagem) {
		super(mensagem);
	}
}