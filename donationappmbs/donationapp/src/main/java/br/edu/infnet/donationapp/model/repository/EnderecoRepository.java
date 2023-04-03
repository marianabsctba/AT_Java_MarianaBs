package br.edu.infnet.donationapp.model.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.donationapp.model.domain.Endereco;

@FeignClient(url="https://viacep.com.br/ws/", name = "ViaCepService")
public interface EnderecoRepository {

  @GetMapping("{cep}/json")
  Endereco getAddress(@PathVariable("cep") String cep);
}
