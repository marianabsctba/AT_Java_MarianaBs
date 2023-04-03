package br.edu.infnet.donationapp.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.edu.infnet.donationapp.model.exceptions.TransacaoSemDoadorException;
import br.edu.infnet.donationapp.model.exceptions.TransacaoSemProdutoException;


@Entity
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private boolean entregaComFrete;
	private LocalDateTime data;
	@OneToOne(cascade = CascadeType.DETACH) 
	@JoinColumn(name = "idDoador")
	private Doador doador;
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Produto> produtos;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	public Transacao() {
		// TODO Auto-generated constructor stub
	}
	
	public Transacao(Doador doador, List<Produto> produtos) throws TransacaoSemDoadorException, TransacaoSemProdutoException {
		this();
		
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
				entregaComFrete ? "sim" : "não",  
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
	
	public boolean isEntregaComFrete() {
		return entregaComFrete;
	}

	public void setEntregaComFrete(boolean entregaComFrete) {
		this.entregaComFrete = entregaComFrete;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public void setDoador(Doador doador) {
		this.doador = doador;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}