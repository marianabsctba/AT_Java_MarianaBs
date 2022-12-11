package br.edu.infnet.donationapp.model.tests;

import br.edu.infnet.donationapp.model.domain.Alimento;
import br.edu.infnet.donationapp.model.exceptions.TamanhoMovelInvalidoException;
import br.edu.infnet.donationapp.model.exceptions.ValidadeAlimentoInvalidoException;
import br.edu.infnet.donationapp.model.exceptions.ValorZeradoException;

public class AlimentoTest {

	public static void main(String[] args) {
				
		try {
			Alimento b1 = new Alimento("1", "arroz", 20, "Tio Joao");
			b1.setPerecivel(false);
			b1.setMeses(50);
			System.out.println(b1);
			System.out.println("Valor para declaração IRPF = R$" + b1.calcValorIRPF());
		} catch (ValorZeradoException | ValidadeAlimentoInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Alimento b1 = new Alimento("2", "feijão", 10, "DoCarioca");
			b1.setPerecivel(false);
			b1.setMeses(200);
			System.out.println(b1);
			System.out.println("Valor para declaração IRPF = R$" + b1.calcValorIRPF());
		} catch (ValorZeradoException | ValidadeAlimentoInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Alimento b2 = new Alimento("3", "chips", -10, "GordsChip");
			b2.setPerecivel(true);
			b2.setMeses(300);
			System.out.println(b2);
			System.out.println("Valor para declaração IRPF = R$" + b2.calcValorIRPF());
		} catch (ValorZeradoException | ValidadeAlimentoInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Alimento b3 = new Alimento("4", "atum", 0, "PoorFish");
			b3.setPerecivel(true);
			b3.setMeses(24);
			System.out.println(b3);
			System.out.println("Valor para declaração IRPF = R$" + b3.calcValorIRPF());
		} catch (ValorZeradoException | ValidadeAlimentoInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}