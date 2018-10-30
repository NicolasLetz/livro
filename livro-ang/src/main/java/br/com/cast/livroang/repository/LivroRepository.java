package br.com.cast.livroang.repository;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cast.livroang.entidades.Livro;

@Repository
public class LivroRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void inserir(Livro livro) {
		entityManager.persist(livro);
	}
	
	public List<Livro> buscarTodos() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("FROM ").append(Livro.class.getName()).append(" l ")
			.append(" join fetch l.autor")
			.append(" join fetch l.categoria");
		Query query = entityManager.createQuery(jpql.toString());
		
		@SuppressWarnings("unchecked")
		List<Livro> livros = query.getResultList();
		return livros ;
	}
	
	public Livro buscarPorId(Integer id) {
		return entityManager.find(Livro.class, id);
	}
	
	public void alterar(Livro livro) {
		entityManager.merge(livro);
	}
	
	public void remover(Livro livro) {
		entityManager.remove(livro);
	}

	public Livro buscarPorTitulo(String titulo) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("FROM ").append(Livro.class.getName()).append(" WHERE lower(titulo) = :titulo");
		Query query = entityManager.createQuery(jpql.toString());
		query.setParameter("titulo", titulo.toLowerCase());
		@SuppressWarnings("unchecked")
		List<Livro> livros = query.getResultList();
		return livros.size()>0 ? livros.get(0) : null ;
	}
}
