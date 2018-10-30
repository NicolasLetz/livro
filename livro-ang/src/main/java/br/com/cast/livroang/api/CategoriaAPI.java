package br.com.cast.livroang.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.livroang.business.CategoriaBusiness;
import br.com.cast.livroang.dtos.CategoriaDTO;

@RestController
@RequestMapping(path="/categoria/")
public class CategoriaAPI {
	@Autowired
	CategoriaBusiness categoriaBusiness;
	
	@RequestMapping(path="todas", method= RequestMethod.GET)
	public List<CategoriaDTO> buscarTodas() {
		return categoriaBusiness.buscarTodas();
	}
}
