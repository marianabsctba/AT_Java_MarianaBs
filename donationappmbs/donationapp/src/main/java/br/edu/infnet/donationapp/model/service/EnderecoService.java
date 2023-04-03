package br.edu.infnet.donationapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.donationapp.model.domain.Endereco;
import edu.br.infnet.donationapp.clients.IEnderecoClient;

@Service
public class EnderecoService {

	@Autowired(required = false)
	private IEnderecoClient enderecoClient;

	public Endereco buscaPorCep(String cep) {

		return enderecoClient.buscaPorCep(cep);
	}
}
