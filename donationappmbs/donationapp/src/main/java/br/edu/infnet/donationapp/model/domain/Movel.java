package br.edu.infnet.donationapp.model.domain;

import javax.persistence.Entity;

import br.edu.infnet.donationapp.model.exceptions.TamanhoMovelInvalidoException;
import br.edu.infnet.donationapp.model.exceptions.ValorZeradoException;




@Entity
public class Movel extends Produto {

	private boolean usado;
	private int tamanho;
	private String marca;

	public Movel(String nome, float valor, String marca) throws ValorZeradoException {
		super(nome, valor);
		this.marca = marca;
	}

public Movel() {
		
	}

	@Override
	public float calcValor() throws TamanhoMovelInvalidoException {

		if (tamanho > 200) {
			throw new TamanhoMovelInvalidoException("O tamanho do móvel está inválido! É maior do que 200cm!");
		}

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

		return sb.toString();
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
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
