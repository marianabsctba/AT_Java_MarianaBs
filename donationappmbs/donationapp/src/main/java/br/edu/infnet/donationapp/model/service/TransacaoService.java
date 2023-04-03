package br.edu.infnet.donationapp.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.donationapp.model.domain.Transacao;
import br.edu.infnet.donationapp.model.domain.Usuario;
import br.edu.infnet.donationapp.model.repository.TransacaoRepository;

@Service
public class TransacaoService {
	
	@Autowired
	
	private TransacaoRepository transacaoRepository; 
	
	public Transacao incluir(Transacao transacao) {
		return transacaoRepository.save(transacao);
	}
	
	public void excluir(Integer id) {
		 transacaoRepository.deleteById(id);
	}
	
	
	public Collection<Transacao> obterLista() {
		return (Collection<Transacao>) transacaoRepository.findAll();
		
	}
	
	public Collection<Transacao> obterLista(Usuario usuario) {
		return (Collection<Transacao>) transacaoRepository.obterLista(usuario.getId());
		
	}
	
	public Transacao obterPorId(Integer id) {
		return transacaoRepository.findById(id).orElse(null);
	}


}