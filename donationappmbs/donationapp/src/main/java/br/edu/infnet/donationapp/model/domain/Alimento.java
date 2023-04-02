package br.edu.infnet.donationapp.model.domain;

import javax.persistence.Entity;

import br.edu.infnet.donationapp.model.exceptions.ValidadeAlimentoInvalidoException;
import br.edu.infnet.donationapp.model.exceptions.ValorZeradoException;



@Entity
public class Alimento extends Produto {

	private boolean perecivel;
	private int meses;
	private String marca;

	
	public Alimento() {
		
	}
	public Alimento(String nome, float valor, String marca, int meses) throws ValorZeradoException {
		super(nome, valor);
		this.marca = marca;
		this.meses = meses;
	}
	
	
	@Override
	public float calcValor() throws ValidadeAlimentoInvalidoException {
		
		if(meses >= 60) {
			throw new ValidadeAlimentoInvalidoException("O alimento foi fabricado após muitos meses...oppps..imprório para consumo!");
		}
		
		return this.getValor();
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
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
	public String setMarca(String marca) {
		return this.marca = marca;
	}

}
