package br.edu.infnet.donationapp.model.tests;

import br.edu.infnet.donationapp.model.domain.Vestuario;
import br.edu.infnet.donationapp.model.exceptions.TamanhoVestuarioInvalidoException;
import br.edu.infnet.donationapp.model.exceptions.ValorZeradoException;

public class VestuarioTest {

	public static void main(String[] args) {
				
		try {
			Vestuario v1 = new Vestuario("blusa", 42, "Dudalina");
			v1.setUsado(false);
			v1.setTamanho(500);
			System.out.println(v1);
			System.out.println("Valor para restituição IRPF  = R$" + v1.calcValor());
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Vestuario v2 = new Vestuario("calça", 31, "C&A");
			v2.setUsado(false);
			v2.setTamanho(200);
			System.out.println(v2);
			System.out.println("Valor para restituição IRPF  = R$" + v2.calcValor());
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Vestuario v3 = new Vestuario("bolsa", -10, "Guucci");
			v3.setUsado(true);
			v3.setTamanho(300);
			System.out.println(v3);
			System.out.println("Valor para restituição IRPF  = R$" + v3.calcValor());
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Vestuario v4 = new Vestuario("Casaco", 0, "Renner");
			v4.setUsado(true);
			v4.setTamanho(1000);
			System.out.println(v4);
			System.out.println("Valor para restituição IRPF  = R$" + v4.calcValor());
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}