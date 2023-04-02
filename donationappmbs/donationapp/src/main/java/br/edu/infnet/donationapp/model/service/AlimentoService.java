package br.edu.infnet.donationapp.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.donationapp.model.domain.Alimento;
import br.edu.infnet.donationapp.model.domain.Usuario;
import br.edu.infnet.donationapp.model.repository.AlimentoRepository;

@Service
public class AlimentoService {
	
	@Autowired
	
	private AlimentoRepository alimentoRepository; 
	
	public Alimento incluir(Alimento alimento) {
		return alimentoRepository.save(alimento);
	}
	
	public void excluir(Integer id) {
		 alimentoRepository.deleteById(id);
	}
	
	
	public Collection<Alimento> obterLista() {
		return (Collection<Alimento>) alimentoRepository.findAll();
		
	}
	
	public Collection<Alimento> obterLista(Usuario usuario) {
		return (Collection<Alimento>) alimentoRepository.obterLista(usuario.getId());
		
	}
	
	public Alimento obterPorId(Integer id) {
		return alimentoRepository.findById(id).orElse(null);
	}


}