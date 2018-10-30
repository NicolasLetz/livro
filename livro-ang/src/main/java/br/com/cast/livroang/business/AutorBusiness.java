package br.com.cast.livroang.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cast.livroang.dtos.AutorDTO;
import br.com.cast.livroang.entidades.Autor;
import br.com.cast.livroang.repository.AutorRepository;

@Component
public class AutorBusiness {
	
	@Autowired
	private AutorRepository autorRepository;
	
	public Autor buscarPorId(Integer id) {
		return autorRepository.buscarPorId(id);
	}

	public List<AutorDTO> buscarTodos() {
		List<AutorDTO> autoresDto = new ArrayList<>();
		List<Autor> autores = autorRepository.buscarTodos();
		
		for (Autor autor : autores) {
			AutorDTO dto = new AutorDTO();
			dto.setId(autor.getId());
			dto.setNome(autor.getNome());
			dto.setPseudonimo(autor.getPseudonimo());
			autoresDto.add(dto);
		}
		
		return autoresDto;
	}
}
