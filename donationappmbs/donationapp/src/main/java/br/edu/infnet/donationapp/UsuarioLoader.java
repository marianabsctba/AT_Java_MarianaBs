package br.edu.infnet.donationapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.donationapp.model.domain.Usuario;
import br.edu.infnet.donationapp.model.service.UsuarioService;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {


		Usuario admin = new Usuario("Administrador", "admin@admin.com", "12345");
		admin.setIdade(33);
		admin.setTipo("PJ");

		usuarioService.incluir(admin);
		System.out.println("Administrador criado!");

		try {
			String arq = "usuarios.txt";

			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);

				String linha = leitura.readLine();

				while (linha != null) {
					
					String[] campos = null;

					campos = linha.split(";");

					Usuario usuario = new Usuario(campos[0], campos[1], campos[2]);
					usuario.setNome(campos[0]);
					usuario.setIdade(Integer.valueOf(campos[3]));
					usuario.setTipo(String.valueOf(campos[4]));

					usuarioService.incluir(usuario);

					System.out.println("Usuario " + usuario.getNome() + " incluído com sucesso!");

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