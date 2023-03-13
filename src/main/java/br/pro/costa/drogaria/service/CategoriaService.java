package br.pro.costa.drogaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pro.costa.drogaria.domain.Categoria;
import br.pro.costa.drogaria.exception.RecursoNaoEncontradoException;
import br.pro.costa.drogaria.repository.CategoriaRepository;
@Service 
public class CategoriaService {
@Autowired
	private CategoriaRepository categoriaRepository;
public Categoria buscarPorCodigo(Short codigo) {
	java.util.Optional<Categoria>resultado=categoriaRepository.findById(codigo);
	if(resultado.isEmpty()) {
		throw new RecursoNaoEncontradoException();
		
	}
	Categoria categoria =resultado.get();
	return categoria;
}
public List<Categoria> listar(){
	List<Categoria>resultado = categoriaRepository.findAll();
	return resultado;
}
}
