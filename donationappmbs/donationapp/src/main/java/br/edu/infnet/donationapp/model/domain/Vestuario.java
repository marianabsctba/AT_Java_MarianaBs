package br.edu.infnet.donationapp.model.domain;

import br.edu.infnet.donationapp.model.domain.Produto;
import br.edu.infnet.donationapp.model.exceptions.TamanhoVestuarioInvalidoException;
import br.edu.infnet.donationapp.model.exceptions.ValorZeradoException;

public class Vestuario extends Produto {

	private boolean novo;
	private int tamanho;
	private String marca;

	public Vestuario(String id, String nome, float valor, String marca) throws ValorZeradoException {
		super(id, nome, valor);
		this.marca = marca;
	}

	@Override
	public float calcValorIRPF() throws TamanhoVestuarioInvalidoException {
		
		if(tamanho < 36) {
			throw new TamanhoVestuarioInvalidoException("O tamanho min da roupa para doação é 36!");
		}
		
		return this.getValor() + (novo ? 3 : 0) + tamanho * 0.05f;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(novo ? "novo=S" : "novo=N");
		sb.append(";");
		sb.append(tamanho);
		sb.append(";");
		sb.append(marca);

		return sb.toString();
	}
	
	public boolean isNova() {
		return novo;
	}
	public void setNova(boolean tempoDaPeca) {
		this.novo = tempoDaPeca;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public String getMarca() {
		return marca;
	}
}
