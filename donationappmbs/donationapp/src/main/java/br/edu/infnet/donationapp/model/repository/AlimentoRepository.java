package br.edu.infnet.donationapp.model.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.donationapp.model.domain.Alimento;
import br.edu.infnet.donationapp.model.domain.Doador;

@Repository
public interface AlimentoRepository extends CrudRepository <Alimento, Integer>  {
	
	@Query("from Alimento a where a.usuario.id = :userId")	
	List<Alimento> obterLista(Integer userId);

}