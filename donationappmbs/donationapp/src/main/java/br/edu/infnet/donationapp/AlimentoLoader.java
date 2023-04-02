package br.edu.infnet.donationapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.donationapp.model.domain.Alimento;
import br.edu.infnet.donationapp.model.domain.Usuario;
import br.edu.infnet.donationapp.model.service.AlimentoService;

@Order(3)
@Component
public class AlimentoLoader implements ApplicationRunner {

	@Autowired
	private AlimentoService alimentoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		

		try {
			String arq = "alimentos.txt";

			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);

				String linha = leitura.readLine();
				String[] campos = null;


				while (linha != null) {

					campos = linha.split(";");
					
					Usuario usuario = new Usuario();
					usuario.setId(1);


					Alimento alimento = new Alimento(campos[0], Float.valueOf(campos[3]), campos[1], 0);
					alimento.setPerecivel(Boolean.valueOf(campos[2]));
					alimento.setMeses(Integer.valueOf(campos[4]));					
					alimento.setUsuario(usuario);
					alimentoService.incluir(alimento);
					

					System.out.println("Alimento " + alimento.getNome() + " incluído com sucesso!");

					linha = leitura.readLine();
				}

				leitura.close();
				fileR.close();
			} catch (

			IOException e) {
				System.out.println("[ERRO] " + e.getMessage());
			}
			
			//System.out.println("Lista");
			//for( Alimento alimento : alimentoService.obterLista()) {
				//System.out.printf("", 
						//alimento.getId(),
						//alimento.getNome(),
						//alimento.getMeses(),
						//alimento.getValor(),
						//alimento.getMarca());				
			//}


		} finally {
			System.out.println("Processamento realizado com sucesso! :D");
		}
	}

}