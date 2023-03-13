package br.pro.costa.drogaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.pro.costa.drogaria.domain.Categoria;
import br.pro.costa.drogaria.exception.RecursoNaoEncontradoException;
import br.pro.costa.drogaria.repository.CategoriaRepository;
import br.pro.costa.drogaria.service.CategoriaService;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
@RestController
@RequestMapping("categorias")
public class CategoriaController {
	@Autowired 
	private CategoriaService categoriaService;
private CategoriaRepository categoriaRepository;
	@GetMapping
	public List<Categoria> listar(){
		List<Categoria> categorias=categoriaService.listar();
		return categorias;
	} 
	@GetMapping("/{codigo}")
	public Categoria buscarPorCodigo(@PathVariable Short codigo){
		try {
		//java.util.Optional<Categoria>resultado=categoriaRepository.findById(codigo);
		Categoria categoria =categoriaService.buscarPorCodigo(codigo);
		return categoria;
		}catch(RecursoNaoEncontradoException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada", e);
		}
	}
	
	@PostMapping()
	public Categoria inserir(@RequestBody Categoria categoria) {
		Categoria categoriaSalva=categoriaRepository.save(categoria);
		return categoriaSalva;
	}
	@DeleteMapping("/{codigo}")
public Categoria excluir(@PathVariable Short codigo) {
	java.util.Optional<Categoria> categoria= categoriaRepository.findById(codigo);
	categoriaRepository.delete(categoria.get());
	Categoria categoriaRetorno=categoria.get();
	return categoriaRetorno;
}
	//@PutMapping
	public Categoria editar(@RequestBody Categoria categoria) {
		Categoria categoriaEditada = categoriaRepository.save(categoria);
		return categoriaEditada;
	}
}



