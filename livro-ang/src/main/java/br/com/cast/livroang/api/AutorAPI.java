package br.com.cast.livroang.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.livroang.business.AutorBusiness;
import br.com.cast.livroang.dtos.AutorDTO;

@RestController
@RequestMapping(path="/autor/")
public class AutorAPI {
	@Autowired
	AutorBusiness autorBusiness;
	
	@RequestMapping(path="todos", method= RequestMethod.GET)
	public List<AutorDTO> todos() {
		return autorBusiness.buscarTodos();
	}
}
