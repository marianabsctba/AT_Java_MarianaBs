package br.edu.infnet.donationapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.donationapp.model.domain.Doador;
import br.edu.infnet.donationapp.model.domain.Usuario;
import br.edu.infnet.donationapp.model.service.DoadorService;

@Order(2)
@Component
public class DoadorLoader implements ApplicationRunner {

	@Autowired
	private DoadorService doadorService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		try {
			String arq = "doadores.txt";

			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);

				String linha = leitura.readLine();
				String[] campos = null;

				while (linha != null) {

					campos = linha.split(";");
					
					Usuario usuario = new Usuario();
					usuario.setId(1);

					Doador doador = new Doador(
							campos[0],
							campos[1],
							campos[2],
							campos[3]
									);
					
					doador.setUsuario(usuario);
					
					doadorService.incluir(doador);

					System.out.println("Doador " + doador.getNome() + " incluído com sucesso!");

					linha = leitura.readLine();
				}

				leitura.close();
				fileR.close();
			} catch (

			IOException e) {
				System.out.println("[ERRO] " + e.getMessage());
			}

		} finally {
			System.out.println("Processamento realizado com sucesso! :D");
		}
	}

}
