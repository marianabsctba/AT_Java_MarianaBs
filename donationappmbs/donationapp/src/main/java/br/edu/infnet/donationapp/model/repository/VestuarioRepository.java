package br.edu.infnet.donationapp.model.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.donationapp.model.domain.Doador;
import br.edu.infnet.donationapp.model.domain.Vestuario;

@Repository
public interface VestuarioRepository extends CrudRepository <Vestuario, Integer>  {
	
	@Query("from Vestuario v where v.usuario.id = :userId")	
	List<Vestuario> obterLista(Integer userId);

}