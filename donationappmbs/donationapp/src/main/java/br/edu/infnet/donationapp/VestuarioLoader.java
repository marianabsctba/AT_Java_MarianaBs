package br.edu.infnet.donationapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.donationapp.model.domain.Alimento;
import br.edu.infnet.donationapp.model.domain.Vestuario;
import br.edu.infnet.donationapp.model.service.AlimentoService;
import br.edu.infnet.donationapp.model.service.VestuarioService;

@Component
public class VestuarioLoader implements ApplicationRunner {

	@Autowired
	private VestuarioService vestuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		try {
			String arq = "vestuarios.txt";

			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);

				String linha = leitura.readLine();
				String[] campos = null;

				while (linha != null) {

					campos = linha.split(";");

					Vestuario vestuario = new Vestuario(campos[0], Float.valueOf(campos[3]),
							campos[1]);
					vestuario.setUsado(Boolean.valueOf(campos[2]));
					vestuario.setTamanho(Integer.valueOf(campos[4]));
					vestuario.setRoupa(Boolean.valueOf(campos[5]));

					
					vestuarioService.incluir(vestuario);

					System.out.println("Vestuário " + vestuario.getNome() + " incluído com sucesso!");

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
