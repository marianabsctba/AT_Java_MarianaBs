package br.edu.infnet.donationapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.donationapp.model.domain.Transacao;
import br.edu.infnet.donationapp.model.domain.Usuario;
import br.edu.infnet.donationapp.model.service.DoadorService;
import br.edu.infnet.donationapp.model.service.ProdutoService;
import br.edu.infnet.donationapp.model.service.TransacaoService;

@Controller
public class TransacaoController {
	

	
	@Autowired
	private TransacaoService transacaoService;
	@Autowired
	private DoadorService doadorService;
	@Autowired
	private ProdutoService produtoService;

	private String msg;

	@GetMapping(value = "/transacao")
	public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("doadores", doadorService.obterLista(usuario));
				
		model.addAttribute("produtos", produtoService.obterLista(usuario));

		return "transacao/cadastro";
	}	

	@GetMapping(value = "/transacao/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("transacoes", transacaoService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "transacao/lista";
	}
	
	@PostMapping(value = "/transacao/incluir")
	public String incluir(Transacao transacao, @SessionAttribute("user") Usuario usuario) {
		
		transacao.setUsuario(usuario);

		transacaoService.incluir(transacao);

		msg = "A inclusão da transacao "+transacao.getDescricao()+" foi realizada com sucesso!!!";
		
		return "redirect:/transacao/lista";
	}
		
	@GetMapping(value = "/transacao/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Transacao transacao = transacaoService.obterPorId(id);
		
		transacaoService.excluir(id);
		
		msg = "A exclusão da transação "+transacao.getDescricao()+" foi realizada com sucesso!!!";

		return "redirect:/transacao/lista";
	}
}
