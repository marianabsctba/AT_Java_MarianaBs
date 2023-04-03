package br.edu.infnet.donationapp.model.tests;

import br.edu.infnet.donationapp.model.domain.Alimento;
import br.edu.infnet.donationapp.model.exceptions.ValidadeAlimentoInvalidoException;
import br.edu.infnet.donationapp.model.exceptions.ValorZeradoException;



public class AlimentoTest {

	public static void main(String[] args) {
				
		try {
			Alimento b1 = new Alimento("arroz", 20, "Tio Joao", 11);
			b1.setPerecivel(false);
			b1.setMeses(50);
			System.out.println(b1);
			System.out.println("Valor para declaração IRPF = R$" + b1.calcValor());
		} catch (ValorZeradoException | ValidadeAlimentoInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Alimento b1 = new Alimento("feijão", 10, "DoCarioca", 11);
			b1.setPerecivel(false);
			b1.setMeses(200);
			System.out.println(b1);
			System.out.println("Valor para declaração IRPF = R$" + b1.calcValor());
		} catch (ValorZeradoException | ValidadeAlimentoInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Alimento b2 = new Alimento("chips", -10, "GordsChip", 12);
			b2.setPerecivel(true);
			b2.setMeses(300);
			System.out.println(b2);
			System.out.println("Valor para declaração IRPF = R$" + b2.calcValor());
		} catch (ValorZeradoException | ValidadeAlimentoInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Alimento b3 = new Alimento("atum", 0, "PoorFish", 21);
			b3.setPerecivel(true);
			b3.setMeses(24);
			System.out.println(b3);
			System.out.println("Valor para declaração IRPF = R$" + b3.calcValor());
		} catch (ValorZeradoException | ValidadeAlimentoInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}