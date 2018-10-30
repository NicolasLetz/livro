package br.com.cast.livroang.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.livroang.entidades.Categoria;

@Repository
public class CategoriaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Categoria buscarPorId(Integer id) {
		return entityManager.find(Categoria.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> buscarTodas() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("FROM ").append(Categoria.class.getName());
		Query query = entityManager.createQuery(jpql.toString());
		return query.getResultList();
	}
}
