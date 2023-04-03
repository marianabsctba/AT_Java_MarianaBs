package br.edu.infnet.donationapp.model.repository;


import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.donationapp.model.domain.Doador;

@Repository
public interface DoadorRepository extends CrudRepository <Doador, Integer>  {
	
	@Query("from Doador g where g.usuario.id = :userId")	
	List<Doador> obterLista(Integer userId, Sort sort);


}