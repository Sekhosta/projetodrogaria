package br.pro.costa.drogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pro.costa.drogaria.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Short>{

}
