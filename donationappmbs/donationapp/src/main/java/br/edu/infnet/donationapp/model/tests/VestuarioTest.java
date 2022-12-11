package br.edu.infnet.donationapp.model.tests;

import br.edu.infnet.donationapp.model.domain.Vestuario;
import br.edu.infnet.donationapp.model.exceptions.TamanhoVestuarioInvalidoException;
import br.edu.infnet.donationapp.model.exceptions.ValorZeradoException;

public class VestuarioTest {

	public static void main(String[] args) {
				
		try {
			Vestuario v1 = new Vestuario("18", "blusa", 42, "Dudalina");
			v1.setNova(false);
			v1.setTamanho(500);
			System.out.println(v1);
			System.out.println("Valor para restituição IRPF  = R$" + v1.calcValorIRPF());
		} catch (ValorZeradoException | TamanhoVestuarioInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Vestuario v2 = new Vestuario("21", "calça", 31, "C&A");
			v2.setNova(false);
			v2.setTamanho(200);
			System.out.println(v2);
			System.out.println("Valor para restituição IRPF  = R$" + v2.calcValorIRPF());
		} catch (ValorZeradoException | TamanhoVestuarioInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Vestuario v3 = new Vestuario("30", "bolsa", -10, "Guucci");
			v3.setNova(true);
			v3.setTamanho(300);
			System.out.println(v3);
			System.out.println("Valor para restituição IRPF  = R$" + v3.calcValorIRPF());
		} catch (ValorZeradoException | TamanhoVestuarioInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Vestuario v4 = new Vestuario("33", "Casaco", 0, "Renner");
			v4.setNova(true);
			v4.setTamanho(1000);
			System.out.println(v4);
			System.out.println("Valor para restituição IRPF  = R$" + v4.calcValorIRPF());
		} catch (ValorZeradoException | TamanhoVestuarioInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}