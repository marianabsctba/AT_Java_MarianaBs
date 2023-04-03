package br.edu.infnet.donationapp.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.donationapp.model.domain.Alimento;
import br.edu.infnet.donationapp.model.domain.Usuario;
import br.edu.infnet.donationapp.model.domain.Vestuario;
import br.edu.infnet.donationapp.model.repository.VestuarioRepository;

@Service
public class VestuarioService {

	@Autowired

	private VestuarioRepository vestuarioRepository;

	public Vestuario incluir(Vestuario vestuario) {
		return vestuarioRepository.save(vestuario);
	}

	public void excluir(Integer id) {
		vestuarioRepository.deleteById(id);
	}

	public Collection<Vestuario> obterLista() {
		return (Collection<Vestuario>) vestuarioRepository.findAll();
		
	}
	
	public Collection<Vestuario> obterLista(Usuario usuario) {
		return (Collection<Vestuario>) vestuarioRepository.obterLista(usuario.getId());
		
	}
	
	public Vestuario obterPorId(Integer id) {
		return vestuarioRepository.findById(id).orElse(null);
	}


}