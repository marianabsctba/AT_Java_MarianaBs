package br.edu.infnet.donationapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.donationapp.model.domain.Movel;
import br.edu.infnet.donationapp.model.domain.Usuario;
import br.edu.infnet.donationapp.model.service.MovelService;

@Controller
public class MovelController {
	
	@Autowired	
	private MovelService movelService;


	private String msg;

	@GetMapping(value = "/movel")
	public String telaCadastro() {
		return "produto/movel/cadastro";
	}

	@GetMapping(value = "/movel/lista")
	public String telaLista(Model model,  @SessionAttribute ("user") Usuario usuario) {

		model.addAttribute("moveis", movelService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		msg = null;

		return "produto/movel/lista";
	}

	@PostMapping(value = "/movel/incluir")
	public String incluir(Movel movel, @SessionAttribute ("user") Usuario usuario) {
		System.out.println("Cadastrado com sucesso!!" + movel.toString());
		
		movel.setUsuario(usuario);

		movelService.incluir(movel);
		
		msg = "movel " + movel.getNome() + " criado com sucesso!";


		return "redirect:/movel/lista";
	}

	@GetMapping(value = "/movel/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		Movel movel = movelService.obterPorId(id);

		movelService.excluir(id);

		msg = "Exclusão do movel " + movel.getNome() + " feito com sucesso!";

		return "redirect:/movel/lista";
	}

}
