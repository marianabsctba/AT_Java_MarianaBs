package br.edu.infnet.donationapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.donationapp.model.domain.Vestuario;
import br.edu.infnet.donationapp.model.service.VestuarioService;

@Controller
public class VestuarioController {
	
	@Autowired	
	private VestuarioService vestuarioService;

	private String msg;

	@GetMapping(value = "/vestuario")
	public String telaCadastro() {
		return "produto/vestuario/cadastro";
	}

	@GetMapping(value = "/vestuario/lista")
	public String telaLista(Model model) {

		model.addAttribute("vestuarios", vestuarioService.obterLista());

		model.addAttribute("mensagem", msg);
		msg = null;

		return "produto/vestuario/lista";
	}

	@PostMapping(value = "/vestuario/incluir")
	public String incluir(Vestuario vestuario) {
		System.out.println("Cadastrado com sucesso!!" + vestuario.toString());

		vestuarioService.incluir(vestuario);
		
		msg = "vestuario " + vestuario.getNome() + " criado com sucesso!";

		return "redirect:/vestuario/lista";
	}

	@GetMapping(value = "/vestuario/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		vestuarioService.excluir(id);

		msg = "Exclusão do vestuario ("+id+") feito com sucesso!";

		return "redirect:/vestuario/lista";
	}
}

