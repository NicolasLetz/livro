package br.com.cast.livroang.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.livroang.business.LivroBusiness;
import br.com.cast.livroang.dtos.LivroDTO;
import br.com.cast.livroang.dtos.ResultsDTO;
import br.com.cast.livroang.exceptions.DuplicatedBookException;

@RestController
@RequestMapping(path="/livro/")
public class LivroAngAPI {
	@Autowired
	private LivroBusiness livroBusiness;
	
	@RequestMapping(path="todos", method= RequestMethod.GET)
	public List<ResultsDTO> getTodos() {
		return livroBusiness.buscarTodos();
	}
	
	@RequestMapping(path="insert", method= RequestMethod.POST)
	public String post(@RequestBody LivroDTO livroDto) {
		try {
			livroBusiness.inserir(livroDto);
		} catch (DuplicatedBookException e) {
			return "Duplicado";
		}
		return "Inserido!";
	}
	@RequestMapping(path="delete/{titulo}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("titulo") String titulo) {
		livroBusiness.remover(titulo);
	}
	@RequestMapping(path="buscar/{titulo}", method= RequestMethod.GET)
	public LivroDTO buscarPorTitulo(@PathVariable("titulo") String titulo) {
		return livroBusiness.buscarPorTitulo(titulo);
	}
	@RequestMapping(path="alterar/{titulo}", method= RequestMethod.PUT)
	public void alterar(@PathVariable("titulo") String titulo, @RequestBody LivroDTO dto) {
		livroBusiness.alterar(titulo, dto);
	}
}
