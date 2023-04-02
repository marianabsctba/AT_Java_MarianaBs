package br.edu.infnet.donationapp.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.edu.infnet.donationapp.model.exceptions.TransacaoSemDoadorException;
import br.edu.infnet.donationapp.model.exceptions.TransacaoSemProdutoException;


public class Transacao {

	private String descricao;
	private boolean entregaComFrete;
	private LocalDateTime data;
	private Doador doador;
	private List<Produto> produtos;
	
	public Transacao(Doador doador, List<Produto> produtos) throws TransacaoSemDoadorException, TransacaoSemProdutoException {
		
		if(doador == null) {
			throw new TransacaoSemDoadorException("Não existe nenhum doador associado à transação!");
		}
		
		if(produtos == null) {
			throw new TransacaoSemProdutoException("Não existe nenhum produto associado à transação!");
		}

		this.doador = doador;
		this.produtos = produtos;
		
		data = LocalDateTime.now();
	}
	
    public String pegaTransacao() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.descricao);
        sb.append(";");
        sb.append(this.data);
        sb.append(";");
        sb.append(this.doador);
        sb.append("\r\n");

        return sb.toString();
    }

	
	public void imprimir(){
		System.out.println("Transação: " + this);
		System.out.println("Doador: " + doador);
		System.out.println("Quantidade de Produtos: " + produtos.size());
		System.out.println("Produtos:");
		for(Produto p : produtos) {
			System.out.println("- " + p.getNome());
		}
	}
	
	public String obterLinha() {	
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/yyyy");
		
		return this.getData().format(formato)+";"+
			   this.getDescricao()+";"+
			   this.getDoador()+";"+
			   this.getProdutos().size()+"\r\n";
	}
		
	
	@Override
	public String toString() {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		return  String.format("%s;%s;%s", 
				descricao, 
				entregaComFrete ? "web" : "loja",  
				data.format(formato)
			);
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isFrete() {
		return entregaComFrete;
	}
	public void setFrete(boolean frete) {
		this.entregaComFrete = frete;
	}
	public Doador getDoador() {
		return doador;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public LocalDateTime getData() {
		return data;
	}
}