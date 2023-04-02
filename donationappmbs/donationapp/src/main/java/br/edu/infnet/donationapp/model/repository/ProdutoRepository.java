package br.edu.infnet.donationapp.model.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.donationapp.model.domain.Alimento;
import br.edu.infnet.donationapp.model.domain.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository <Produto, Integer>  {
	
	@Query("from Produto p where p.usuario.id = :userId")	
	List<Produto> obterLista(Integer userId);

}