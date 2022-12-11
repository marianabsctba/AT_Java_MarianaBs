package br.edu.infnet.donationapp.model.tests;

import br.edu.infnet.donationapp.model.domain.Movel;
import br.edu.infnet.donationapp.model.exceptions.TamanhoMovelInvalidoException;
import br.edu.infnet.donationapp.model.exceptions.ValorZeradoException;

public class MovelTest {

	public static void main(String[] args) {
				
		try {
			Movel b1 = new Movel("4", "estante", 110, "Tok&Stok");
			b1.setUsado(false);
			b1.setTamanho(500);
			System.out.println(b1);
			System.out.println("Valor para restituição IRPF = R$" + b1.calcValorIRPF());
		} catch (ValorZeradoException | TamanhoMovelInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Movel b1 = new Movel("5", "sofá", 5, "NA");
			b1.setUsado(false);
			b1.setTamanho(200);
			System.out.println(b1);
			System.out.println("Valor para restituição IRPF = R$" + b1.calcValorIRPF());
		} catch (ValorZeradoException | TamanhoMovelInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Movel b2 = new Movel("6", "TV", -10, "Samsung");
			b2.setUsado(true);
			b2.setTamanho(300);
			System.out.println(b2);
			System.out.println("Valor para restituição IRPF = R$" + b2.calcValorIRPF());
		} catch (ValorZeradoException | TamanhoMovelInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Movel b3 = new Movel("7", "cama", 0, "Moveleiro");
			b3.setUsado(true);
			b3.setTamanho(1000);
			System.out.println(b3);
			System.out.println("Valor para restituição IRPF = R$" + b3.calcValorIRPF());
		} catch (ValorZeradoException | TamanhoMovelInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}