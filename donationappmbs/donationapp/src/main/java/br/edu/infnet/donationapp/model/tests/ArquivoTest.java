package br.edu.infnet.donationapp.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.donationapp.model.domain.Transacao;
import br.edu.infnet.donationapp.model.exceptions.TransacaoSemProdutoException;
import br.edu.infnet.donationapp.model.exceptions.TransacaoSemDoadorException;
import br.edu.infnet.donationapp.model.tests.DoadorTest;
import br.edu.infnet.donationapp.model.domain.Alimento;
import br.edu.infnet.donationapp.model.domain.Movel;
import br.edu.infnet.donationapp.model.domain.Vestuario;
import br.edu.infnet.donationapp.model.domain.Produto;
import br.edu.infnet.donationapp.model.domain.Transacao;
import br.edu.infnet.donationapp.model.domain.Doador;
import br.edu.infnet.donationapp.model.exceptions.TransacaoSemProdutoException;
import br.edu.infnet.donationapp.model.exceptions.TransacaoSemDoadorException;
import br.edu.infnet.donationapp.model.exceptions.DoadorInvalidoException;
import br.edu.infnet.donationapp.model.exceptions.ValorZeradoException;

public class ArquivoTest {

	public static void main(String[] args) {

		try {
			String arq = "doacoes.txt";

			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);

				FileWriter fileW = new FileWriter("out_" + arq);
				BufferedWriter escrita = new BufferedWriter(fileW);

				String linha = leitura.readLine();
				String[] campos = null;

				List<Produto> produtos = new ArrayList<Produto>();
				Transacao transacao = null;

				while (linha != null) {

					campos = linha.split(";");

					switch (campos[0].toUpperCase()) {
					case "T":
						try {
							transacao = new Transacao(new Doador(campos[5], campos[3], campos[4], campos[5]), produtos);
							transacao.setDescricao(campos[1]);
							transacao.setFrete(Boolean.valueOf(campos[2]));
						} catch (DoadorInvalidoException | TransacaoSemDoadorException
								| TransacaoSemProdutoException e) {
							System.out.println("[ERRO] " + e.getMessage());
						}

						break;
					case "A":
						try {
							Alimento alimento = new Alimento(campos[0], Float.valueOf(campos[2]), campos[1], 0);
							alimento.setPerecivel(Boolean.valueOf(campos[3]));
							alimento.setMeses(Integer.valueOf(campos[4]));

							produtos.add(alimento);
						} catch (ValorZeradoException e) {
							System.out.println("[ERRO] " + e.getMessage());
						}

						break;
					case "M":
						try {
							Movel movel = new Movel(campos[1], Float.valueOf(campos[3]), campos[5]);
							movel.setUsado(Boolean.valueOf(campos[4]));
							movel.setTamanho(Integer.valueOf(campos[6]));

							produtos.add(movel);
						} catch (ValorZeradoException e) {
							System.out.println("[ERRO] " + e.getMessage());
						}
						break;
					case "V":
						try {
							Vestuario vestuario = new Vestuario(campos[2], Float.valueOf(campos[4]),
									campos[5]);
							vestuario.setUsado(Boolean.valueOf(campos[4]));
							vestuario.setTamanho(Integer.valueOf(campos[6]));

							produtos.add(vestuario);
						} catch (ValorZeradoException e) {
							System.out.println("[ERRO] " + e.getMessage());
						}
						break;

					default:
						System.out.println("Registro inválido!!!");
						break;
					}

					linha = leitura.readLine();
				}

				escrita.write(transacao.obterLinha());

				escrita.close();
				leitura.close();
				fileR.close();
			} catch (IOException e) {
				System.out.println("[ERRO] " + e.getMessage());
			}

		} finally {
			System.out.println("Processamento realizado com sucesso! :D");
		}
	}
}
