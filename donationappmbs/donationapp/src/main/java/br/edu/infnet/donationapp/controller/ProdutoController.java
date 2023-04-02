package br.edu.infnet.donationapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.donationapp.model.domain.Produto;
import br.edu.infnet.donationapp.model.service.ProdutoService;

@Controller
public class ProdutoController {
	
	@Autowired	
	private ProdutoService produtoService;


	private String msg;

	@GetMapping(value = "/produto/lista")
	public String telaLista(Model model) {

		model.addAttribute("produtos", produtoService.obterLista());

		model.addAttribute("mensagem", msg);
		msg = null;

		return "produto/lista";
	}


	@GetMapping(value = "/produto/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		Produto produto = produtoService.obterPorId(id);

		produtoService.excluir(id);

		msg = "Exclusão do produto " + produto.getNome() + " feito com sucesso!";

		return "redirect:/produto/lista";
	}

}
