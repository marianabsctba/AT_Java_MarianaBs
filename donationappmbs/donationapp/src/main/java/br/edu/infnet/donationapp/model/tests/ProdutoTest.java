package br.edu.infnet.donationapp.model.tests;

import br.edu.infnet.donationapp.model.domain.Alimento;
import br.edu.infnet.donationapp.model.domain.Movel;
import br.edu.infnet.donationapp.model.domain.Vestuario;
import br.edu.infnet.donationapp.model.exceptions.ValorZeradoException;

public class ProdutoTest {

	public static void main(String[] args) {
		
		try {
			Alimento a1 = new Alimento("sanduíche", 6, "McDonalds", 0);
			a1.setPerecivel(false);
			a1.setMeses(1);
			System.out.println(a1);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Alimento a2 = new Alimento("macarrão", 10, "DaMamma", 0);
			a2.setPerecivel(true);
			a2.setMeses(12);
			System.out.println(a2);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Alimento a3 = new Alimento("suco", 8, "Polpuddo", 0);
			a3.setPerecivel(true);
			a3.setMeses(26);
			System.out.println(a3);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Movel m1 = new Movel("colchão", 109, "Probel");
			m1.setUsado(true);
			m1.setTamanho(202);
			System.out.println(m1);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Vestuario v1 = new Vestuario("blusa", 1200, "Gucci");
			v1.setUsado(true);
			v1.setTamanho(44);
			System.out.println(v1);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		
	}
	
}

