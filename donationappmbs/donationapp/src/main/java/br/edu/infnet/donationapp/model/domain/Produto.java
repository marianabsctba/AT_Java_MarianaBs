package br.edu.infnet.donationapp.model.domain;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.edu.infnet.donationapp.model.exceptions.TamanhoMovelInvalidoException;
import br.edu.infnet.donationapp.model.exceptions.ValidadeAlimentoInvalidoException;
import br.edu.infnet.donationapp.model.exceptions.ValorZeradoException;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private float valor;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@ManyToMany(mappedBy = "produtos")
	private List<Transacao> transacoes; 
	
	
	public Produto() {
		
	}
	
	public Produto(String nome, float valor) throws ValorZeradoException {
		
		if(valor == 0) {
			throw new ValorZeradoException("O valor do produto está zerado!");
		}
		
		if(valor < 0) {
			throw new ValorZeradoException("O valor do produto é negativo!");
		}

		this.nome = nome;
		this.valor = valor;
	}
	
	public abstract float calcValor() throws ValidadeAlimentoInvalidoException, TamanhoMovelInvalidoException;
	

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();

		sb.append(";");
		sb.append(nome);
		sb.append(";");
		sb.append(valor);

		return sb.toString();
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public float getValor() {
		return valor;
	}	
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
