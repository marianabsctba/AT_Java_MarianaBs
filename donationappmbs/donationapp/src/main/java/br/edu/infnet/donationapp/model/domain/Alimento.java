package br.edu.infnet.donationapp.model.domain;

import br.edu.infnet.donationapp.model.domain.Produto;
import br.edu.infnet.donationapp.model.exceptions.ValidadeAlimentoInvalidoException;
import br.edu.infnet.donationapp.model.exceptions.ValorZeradoException;

public class Alimento extends Produto {

	private boolean perecivel;
	private int meses;
	private String marca;

	public Alimento(String id, String nome, float valor, String marca) throws ValorZeradoException {
		super(id, nome, valor);
		this.marca = marca;
	}
	
	

	@Override
	public float calcValorIRPF() throws ValidadeAlimentoInvalidoException {
		
		if(meses >= 12) {
			throw new ValidadeAlimentoInvalidoException("O alimento foi fabricado após 12 meses...oppps..imprório para consumo!");
		}
		
		return this.getValorIRPF() + (perecivel ? 3 : 0) + meses * 0.05f;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(perecivel ? "perecivel=S" : "perecivel=N");
		sb.append(";");
		sb.append(meses);
		sb.append(";");
		sb.append(marca);

		return sb.toString();
	}
	
	public boolean isPerecivel() {
		return perecivel;
	}
	public void setPerecivel(boolean perecivel) {
		this.perecivel = perecivel;
	}
	public int getMeses() {
		return meses;
	}
	public void setMeses(int meses) {
		this.meses = meses;
	}
	public String getMarca() {
		return marca;
	}
}
