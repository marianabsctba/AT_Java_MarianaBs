package br.edu.infnet.donationapp.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.donationapp.model.domain.Usuario;
import br.edu.infnet.donationapp.model.repository.UsuarioRepository;


@Service
public class UsuarioService {
	
	@Autowired
	
	private UsuarioRepository usuarioRepository; 
	
	public Usuario autenticar(Usuario usuario) {
		return usuarioRepository.autenticacao(usuario.getEmail(), usuario.getSenha());
	}
	
	public Usuario incluir(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public void excluir(Integer id) {
		usuarioRepository.deleteById(id);
	}
	
	
	public Collection<Usuario> obterLista() {
		return (Collection<Usuario>) usuarioRepository.findAll();
		
	}
	
    public Usuario getById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

}
