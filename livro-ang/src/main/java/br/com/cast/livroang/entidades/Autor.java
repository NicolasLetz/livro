package br.com.cast.livroang.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="autor", schema="prova")
public class Autor {
	@Id
	@SequenceGenerator(name="idSeqGen", schema="prova", sequenceName="autor_id_seq",
						allocationSize=1, initialValue=1 )
	@GeneratedValue(generator="idSeqGen", strategy=GenerationType.SEQUENCE)
	private Integer id;
	private String nome;
	private String pseudonimo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPseudonimo() {
		return pseudonimo;
	}
	public void setPseudonimo(String pseudonimo) {
		this.pseudonimo = pseudonimo;
	}
}
