package br.com.cast.livroang.dtos;

import java.util.Date;

public class LivroDTO {
	private Integer id;
	private String titulo;
	private Date dataDePublicacao;
	private AutorDTO autor;
	private CategoriaDTO categoria;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getDataDePublicacao() {
		return dataDePublicacao;
	}
	public void setDataDePublicacao(Date dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}
	public AutorDTO getAutor() {
		return autor;
	}
	public void setAutor(AutorDTO autor) {
		this.autor = autor;
	}
	public CategoriaDTO getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}
}
