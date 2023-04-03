package br.edu.infnet.donationapp.model.tests;

import br.edu.infnet.donationapp.model.domain.Doador;
import br.edu.infnet.donationapp.model.exceptions.DoadorInvalidoException;

public class DoadorTest {

	public static void main(String[] args) {

		try {
			Doador s1 = new Doador("mariana", "1000000000", "mahbs@hotmail.com", "Rua X 557");
			System.out.println(s1);
		} catch (DoadorInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Doador s2 = new Doador(null, "999999", "ma@bu.com", "Rua Y zzz");
			System.out.println(s2);
		} catch (DoadorInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Doador s3 = new Doador("jack", null, "jack@strip.com", "Rua Y kkkk");
			System.out.println(s3);
		} catch (DoadorInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Doador s3 = new Doador("creep", "6666666", null, "Rua KKKK");
			System.out.println(s3);
		} catch (DoadorInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}
