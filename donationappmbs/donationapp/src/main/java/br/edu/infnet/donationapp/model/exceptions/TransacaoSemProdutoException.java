package br.edu.infnet.donationapp.model.exceptions;

public class TransacaoSemProdutoException extends Exception {

	private static final long serialVersionUID = 1L;

	public TransacaoSemProdutoException(String mensagem) {
		super(mensagem);
	}
}