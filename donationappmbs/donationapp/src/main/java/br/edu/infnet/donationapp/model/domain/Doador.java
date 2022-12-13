package br.edu.infnet.donationapp.model.domain;

import br.edu.infnet.donationapp.model.exceptions.DoadorInvalidoException;

public class Doador {

	private String nome;
	private String cpf;
	private String email;
	private String endereco;

	public Doador(String nome, String cpf, String email, String endereco) throws DoadorInvalidoException {
		
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
		sb.append(endereco);
		
		
		return sb.toString();
	}
	
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getEmail() {
		return email;
	}
	public String getEndereco() {
		return email;
	}
}