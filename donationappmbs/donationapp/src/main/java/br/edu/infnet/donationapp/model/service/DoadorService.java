package br.edu.infnet.donationapp.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import br.edu.infnet.donationapp.model.domain.Doador;
import br.edu.infnet.donationapp.model.domain.Usuario;
import br.edu.infnet.donationapp.model.repository.DoadorRepository;

@Service
public class DoadorService {

	@Autowired
	
	private DoadorRepository doadorRepository; 
	
	public Doador incluir(Doador doador) {
		return doadorRepository.save(doador);
	}
	
	public void excluir(Integer key) {
		doadorRepository.deleteById(key);
	}
	
	
	public Collection<Doador> obterLista() {
		return (Collection<Doador>) doadorRepository.findAll();
		
	}
	
	public Collection<Doador> obterLista(Usuario usuario){
		return doadorRepository.obterLista(usuario.getId(), Sort.by(Direction.ASC, "nome"));
	}
}
