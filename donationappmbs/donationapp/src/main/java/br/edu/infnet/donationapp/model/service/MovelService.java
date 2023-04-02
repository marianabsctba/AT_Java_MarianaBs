package br.edu.infnet.donationapp.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.donationapp.model.domain.Movel;
import br.edu.infnet.donationapp.model.repository.MovelRepository;

@Service
public class MovelService {

	@Autowired

	private MovelRepository movelRepository;

	public Movel incluir(Movel alimento) {
		return movelRepository.save(alimento);
	}

	public void excluir(Integer id) {
		movelRepository.deleteById(id);
	}

	public Collection<Movel> obterLista() {
		return (Collection<Movel>) movelRepository.findAll();

	}

	public Movel obterPorId(Integer id) {
		return movelRepository.findById(id).orElse(null);
	}
}
