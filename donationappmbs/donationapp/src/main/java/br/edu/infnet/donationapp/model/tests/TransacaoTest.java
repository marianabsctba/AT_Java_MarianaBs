package br.edu.infnet.donationapp.model.tests;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.donationapp.model.domain.Alimento;
import br.edu.infnet.donationapp.model.domain.Transacao;
import br.edu.infnet.donationapp.model.domain.Produto;
import br.edu.infnet.donationapp.model.domain.Doador;
import br.edu.infnet.donationapp.model.exceptions.TransacaoSemProdutoException;
import br.edu.infnet.donationapp.model.exceptions.TransacaoSemDoadorException;
import br.edu.infnet.donationapp.model.exceptions.DoadorInvalidoException;
import br.edu.infnet.donationapp.model.exceptions.ValorZeradoException;

public class TransacaoTest {

	public static void main(String[] args) {
		List<Produto> produtosP1 = new ArrayList<Produto>();
		List<Produto> produtosP2 = new ArrayList<Produto>();
		List<Produto> produtosP3 = new ArrayList<Produto>();
		List<Produto> produtosP4 = new ArrayList<Produto>();

		try {
			Alimento a1 = new Alimento("arroz", 5, "TioJoao", 0);
			a1.setPerecivel(false);
			a1.setMeses(50);

			produtosP1.add(a1);
			produtosP2.add(a1);
			produtosP4.add(a1);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Alimento a2 = new Alimento("Batata", 10, "McCain", 0);
			a2.setPerecivel(true);
			a2.setMeses(12);

			produtosP2.add(a2);
			produtosP3.add(a2);
			produtosP4.add(a2);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Alimento a3 = new Alimento("Refri", 8, "Coca-Cola", 0);
			a3.setPerecivel(false);
			a3.setMeses(11);

			produtosP3.add(a3);
			produtosP4.add(a3);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Transacao t1 = new Transacao(new Doador("mari", "90455362", "mah_b@hotmail.com", "Rua X" ), produtosP1);
			t1.setDescricao("Primeira doação");
			t1.setFrete(false);
			t1.imprimir();
		} catch (DoadorInvalidoException | TransacaoSemDoadorException | TransacaoSemProdutoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Transacao t2 = new Transacao(new Doador("ana", "99999999", "ann@ann.com.br", "Rua 558"), produtosP2);
			t2.setDescricao("Segunda doação");
			t2.setFrete(true);
			t2.imprimir();
		} catch (DoadorInvalidoException | TransacaoSemDoadorException | TransacaoSemProdutoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Transacao t3 = new Transacao(new Doador("papi", "08000000", "mario@luiz.com", "Rua 222"), produtosP3);
			t3.setDescricao("Terceira doação");
			t3.setFrete(true);
			t3.imprimir();
		} catch (DoadorInvalidoException | TransacaoSemDoadorException | TransacaoSemProdutoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Transacao t4 = new Transacao(new Doador("deni", "12312312312", "deni@maezinha.com", "Rua 99"), produtosP4);
			t4.setDescricao("Quarta doação");
			t4.setFrete(true);
			t4.imprimir();
		} catch (DoadorInvalidoException | TransacaoSemDoadorException | TransacaoSemProdutoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Transacao t5 = new Transacao(null, produtosP4);
			t5.setDescricao("Quinta doação");
			t5.setFrete(true);
			t5.imprimir();
		} catch (TransacaoSemDoadorException | TransacaoSemProdutoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Doador d6 = new Doador("mariazinha", "12312312312", "maria@maria.com", "Rua kkkk");
		
			Transacao t6 = new Transacao(d6, null);
			t6.setDescricao("Sexta doação");
			t6.setFrete(true);
			t6.imprimir();
		} catch (DoadorInvalidoException | TransacaoSemDoadorException | TransacaoSemProdutoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}