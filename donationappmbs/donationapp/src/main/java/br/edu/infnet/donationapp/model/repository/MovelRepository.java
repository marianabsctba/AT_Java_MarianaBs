package br.edu.infnet.donationapp.model.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.donationapp.model.domain.Doador;
import br.edu.infnet.donationapp.model.domain.Movel;

@Repository
public interface MovelRepository extends CrudRepository <Movel, Integer>  {
	
	@Query("from Movel m where m.usuario.id = :userId")	
	List<Movel> obterLista(Integer userId);

}