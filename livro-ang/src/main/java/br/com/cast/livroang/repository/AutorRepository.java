package br.com.cast.livroang.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.livroang.entidades.Autor;

@Repository
public class AutorRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Autor buscarPorId(Integer id) {
		return entityManager.find(Autor.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Autor> buscarTodos() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("FROM ").append(Autor.class.getName());
		
		Query query = entityManager.createQuery(jpql.toString());
		return query.getResultList();
	}
}