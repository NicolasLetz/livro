package br.com.cast.livroang.dtos;

import java.util.Date;

public class ResultsDTO {
	private String titulo;
	private Date dataDePublicacao;
	private String nomeAutor; 
	private String nomeCategoria;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String título) {
		this.titulo = título;
	}
	public Date getDataDePublicacao() {
		return dataDePublicacao;
	}
	public void setDataDePublicacao(Date dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
}
