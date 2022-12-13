package br.edu.infnet.donationapp.model.domain;

import br.edu.infnet.donationapp.model.exceptions.TamanhoVestuarioInvalidoException;
import br.edu.infnet.donationapp.model.exceptions.TamanhoMovelInvalidoException;
import br.edu.infnet.donationapp.model.exceptions.ValidadeAlimentoInvalidoException;
import br.edu.infnet.donationapp.model.exceptions.ValorZeradoException;

public abstract class Produto {

	private String id;
	private String nome;
	private float valorDeclaraçãoIRPF;
	
	public Produto(String codigo, String nome, float valor) throws ValorZeradoException {
		
		if(valor == 0) {
			throw new ValorZeradoException("O valor do produto está zerado!");
		}
		
		if(valor < 0) {
			throw new ValorZeradoException("O valor do produto é negativo!");
		}

		this.id = codigo;
		this.nome = nome;
		this.valorDeclaraçãoIRPF = valor;
	}
	
	public abstract float calcValorIRPF() throws TamanhoVestuarioInvalidoException, ValidadeAlimentoInvalidoException, TamanhoMovelInvalidoException;

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(id);
		sb.append(";");
		sb.append(nome);
		sb.append(";");
		sb.append(valorDeclaraçãoIRPF);

		return sb.toString();
	}

	public String getID() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public float getValorIRPF() {
		return valorDeclaraçãoIRPF;
	}	
}