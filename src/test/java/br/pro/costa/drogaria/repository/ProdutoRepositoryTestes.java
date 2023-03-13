package br.pro.costa.drogaria.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.pro.costa.drogaria.domain.Produto;

@SpringBootTest
public class ProdutoRepositoryTestes {
	@Autowired
	private ProdutoRepository produtoRepository;
	@Test
	public void inserir() {
		Produto p1=new Produto(
				null,
				"Coca Cola",
				Byte.valueOf("15"),
				BigDecimal.valueOf(10.50),
				LocalDate.of(2021, 11, 23),
				null
				);
		Produto p2=new Produto(
				null,
				"Heineken",
				Byte.valueOf("23"),
				BigDecimal.valueOf(08.00),
				LocalDate.of(2022, 4, 01),
				null
				);
		Produto p3=new Produto(
				null,
				"Guaraná Jesus",
				Byte.valueOf("20"),
				BigDecimal.valueOf(08.00),
				LocalDate.of(2022, 5, 01),
				null);
		
		produtoRepository.save(p1);
		produtoRepository.save(p2);
		produtoRepository.save(p3);
	}

}
