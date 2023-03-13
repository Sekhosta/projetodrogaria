package br.pro.costa.drogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pro.costa.drogaria.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
