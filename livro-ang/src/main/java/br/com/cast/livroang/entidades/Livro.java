package br.com.cast.livroang.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="livro", schema="prova")
public class Livro {
	@Id
	@SequenceGenerator(name="idSeqGen", schema="prova", sequenceName="livro_id_seq",
	allocationSize=1, initialValue=1)
	@GeneratedValue(generator= "idSeqGen", strategy= GenerationType.SEQUENCE)
	private Integer id;
	private String titulo;
	private Date dataDePublicacao;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_autor")
	private Autor autor;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_categoria")
	private Categoria categoria;

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
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
