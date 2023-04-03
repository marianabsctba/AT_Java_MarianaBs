package br.edu.infnet.donationapp.model.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.donationapp.model.domain.Transacao;

@Repository
public interface TransacaoRepository extends CrudRepository <Transacao, Integer>  {
	
	@Query("from Transacao t where t.usuario.id = :userId")	
	List<Transacao> obterLista(Integer userId);


}