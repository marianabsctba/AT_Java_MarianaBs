package br.edu.infnet.donationapp.model.tests;

import br.edu.infnet.donationapp.model.domain.Movel;
import br.edu.infnet.donationapp.model.exceptions.TamanhoMovelInvalidoException;
import br.edu.infnet.donationapp.model.exceptions.ValorZeradoException;

public class MovelTest {

	public static void main(String[] args) {
				
		try {
			Movel b1 = new Movel("estante", 110, "Tok&Stok");
			b1.setUsado(false);
			b1.setTamanho(500);
			System.out.println(b1);
			System.out.println("Valor para restituição IRPF = R$" + b1.calcValor());
		} catch (ValorZeradoException | TamanhoMovelInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Movel b1 = new Movel("sofá", 5, "NA");
			b1.setUsado(false);
			b1.setTamanho(200);
			System.out.println(b1);
			System.out.println("Valor para restituição IRPF = R$" + b1.calcValor());
		} catch (ValorZeradoException | TamanhoMovelInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Movel b2 = new Movel("TV", -10, "Samsung");
			b2.setUsado(true);
			b2.setTamanho(300);
			System.out.println(b2);
			System.out.println("Valor para restituição IRPF = R$" + b2.calcValor());
		} catch (ValorZeradoException | TamanhoMovelInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Movel b3 = new Movel("cama", 0, "Moveleiro");
			b3.setUsado(true);
			b3.setTamanho(1000);
			System.out.println(b3);
			System.out.println("Valor para restituição IRPF = R$" + b3.calcValor());
		} catch (ValorZeradoException | TamanhoMovelInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}