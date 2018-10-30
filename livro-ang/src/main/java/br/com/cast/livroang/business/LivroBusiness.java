package br.com.cast.livroang.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.livroang.dtos.AutorDTO;
import br.com.cast.livroang.dtos.CategoriaDTO;
import br.com.cast.livroang.dtos.LivroDTO;
import br.com.cast.livroang.dtos.ResultsDTO;
import br.com.cast.livroang.entidades.Livro;
import br.com.cast.livroang.exceptions.DuplicatedBookException;
import br.com.cast.livroang.repository.LivroRepository;

@Component
public class LivroBusiness {
	
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	CategoriaBusiness categoriaBusiness;
	@Autowired
	AutorBusiness autorBusiness;
	
	public List<ResultsDTO> buscarTodos() {
		List<ResultsDTO> resultado = new ArrayList<>();
		List<Livro> livros = livroRepository.buscarTodos();
		for (Livro livro : livros) {
			ResultsDTO dto = new ResultsDTO();
			
			dto.setDataDePublicacao(livro.getDataDePublicacao());
			dto.setTitulo(livro.getTitulo());

			dto.setNomeCategoria(livro.getCategoria().getDescricao());
			
			dto.setNomeAutor(livro.getAutor().getNome());
			
			resultado.add(dto);
		}
		
		return resultado;
	}
	@Transactional
	public void inserir(LivroDTO livroDto) throws DuplicatedBookException {
		
		if(livroRepository.buscarPorTitulo(livroDto.getTitulo()) != null) {
			throw new DuplicatedBookException();
		}
		
		Livro livro = new Livro();
		livro.setTitulo(livroDto.getTitulo());
		livro.setDataDePublicacao(livroDto.getDataDePublicacao());
		livro.setAutor(autorBusiness.buscarPorId(livroDto.getAutor().getId()));
		livro.setCategoria(categoriaBusiness.buscarPorId(livroDto.getCategoria().getId()));
		
		livroRepository.inserir(livro);
	}
	@Transactional
	public void remover(String titulo) {
		Livro livro =livroRepository.buscarPorTitulo(titulo);
		livroRepository.remover(livro);
	}
	
	public LivroDTO buscarPorTitulo(String titulo) {
		Livro livro = livroRepository.buscarPorTitulo(titulo);
		LivroDTO dto = new LivroDTO();
		dto.setId(livro.getId());
		dto.setTitulo(livro.getTitulo());
		dto.setDataDePublicacao(livro.getDataDePublicacao());
		
		dto.setAutor(new AutorDTO());
		dto.getAutor().setId(livro.getAutor().getId());
		dto.getAutor().setNome(livro.getAutor().getNome());
		dto.getAutor().setPseudonimo(livro.getAutor().getPseudonimo());
		
		dto.setCategoria(new CategoriaDTO());
		dto.getCategoria().setDescricao(livro.getCategoria().getDescricao());
		dto.getCategoria().setId(livro.getCategoria().getId());
		
		return dto;
	}
	
	@Transactional
	public void alterar(String titulo, LivroDTO dto) {
		Livro livro = new Livro();
		
		livro.setId(dto.getId());
		livro.setDataDePublicacao(dto.getDataDePublicacao());
		livro.setTitulo(dto.getTitulo());
		
		livro.setAutor(autorBusiness.buscarPorId(dto.getAutor().getId()));
		
		livro.setCategoria(categoriaBusiness.buscarPorId(dto.getCategoria().getId()));
		
		livroRepository.alterar(livro);
	}
}
