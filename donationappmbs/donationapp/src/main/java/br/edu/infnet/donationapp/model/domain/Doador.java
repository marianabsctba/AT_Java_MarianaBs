package br.edu.infnet.donationapp.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.infnet.donationapp.model.exceptions.DoadorInvalidoException;


@Entity
public class Doador {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private String email;
	private String endereco;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	
	public Doador() {
		
	}
	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

	public Doador(String nome, String cpf, String email, String endereco) throws DoadorInvalidoException {
		
		this();
		
		if(nome == null) {
			throw new DoadorInvalidoException("O nome do doador deve ser preenchido!");
		}
		
		if(cpf == null) {
			throw new DoadorInvalidoException("O CPF do doador deve ser preenchido!");
		}
		
		if(email == null) {
			throw new DoadorInvalidoException("O e-mail do doador deve ser preenchido!");
		}
		if(endereco == null) {
			throw new DoadorInvalidoException("O endereço do doador deve ser preenchido!");
		}
		
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(";");
		sb.append(cpf);
		sb.append(";");
		sb.append(email);
		sb.append(";");
		sb.append(endereco);
		
		
		return sb.toString();
	}
	
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getEmail() {
		return email;
	}
	public String getEndereco() {
		return endereco;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}