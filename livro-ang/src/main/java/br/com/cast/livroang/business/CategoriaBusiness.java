package br.com.cast.livroang.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cast.livroang.dtos.CategoriaDTO;
import br.com.cast.livroang.entidades.Categoria;
import br.com.cast.livroang.repository.CategoriaRepository;

@Component
public class CategoriaBusiness {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscarPorId(Integer id) {
		return categoriaRepository.buscarPorId(id);
	}

	public List<CategoriaDTO> buscarTodas() {
		List<CategoriaDTO> categoriasDto = new ArrayList<>();
		List<Categoria> categorias = categoriaRepository.buscarTodas();
		for (Categoria categoria : categorias) {
			CategoriaDTO dto = new CategoriaDTO();
			dto.setId(categoria.getId());
			dto.setDescricao(categoria.getDescricao());
			categoriasDto.add(dto);
		}
		return categoriasDto;
	}
}
