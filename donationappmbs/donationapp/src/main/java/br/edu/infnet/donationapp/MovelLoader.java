package br.edu.infnet.donationapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.donationapp.model.domain.Movel;
import br.edu.infnet.donationapp.model.service.MovelService;



@Component
public class MovelLoader implements ApplicationRunner {

	@Autowired
	private MovelService movelService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		try {
			String arq = "moveis.txt";

			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);

				String linha = leitura.readLine();
				String[] campos = null;

				while (linha != null) {

					campos = linha.split(";");

					Movel movel = new Movel(campos[0], Float.valueOf(campos[3]), campos[1]);
					movel.setUsado(Boolean.valueOf(campos[2]));
					movel.setTamanho(Integer.valueOf(campos[4]));

					movelService.incluir(movel);

					System.out.println("Móvel " + movel.getNome() + " incluído com sucesso!");

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
