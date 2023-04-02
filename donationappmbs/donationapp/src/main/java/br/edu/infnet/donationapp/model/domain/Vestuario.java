package br.edu.infnet.donationapp.model.domain;

import javax.persistence.Entity;

import br.edu.infnet.donationapp.model.exceptions.ValorZeradoException;



@Entity
public class Vestuario extends Produto {

	private boolean usado;
	private boolean roupa;
	private int tamanho;
	private String marca;

	public Vestuario() {

	}

	public Vestuario(String nome, float valor, String marca) throws ValorZeradoException {
		super(nome, valor);
		this.marca = marca;
	}

	@Override
	public float calcValor() {

		return this.getValor();
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(usado ? "usado=S" : "usado=N");
		sb.append(";");
		sb.append(tamanho);
		sb.append(";");
		sb.append(marca);
		sb.append(";");
		sb.append(roupa ? "roupa=S" : "roupa=N");

		return sb.toString();
	}

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

	public boolean isRoupa() {
		return roupa;
	}

	public void setRoupa(boolean roupa) {
		this.roupa = roupa;
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

	public void setMarca(String marca) {
		this.marca = marca;

	}

}
