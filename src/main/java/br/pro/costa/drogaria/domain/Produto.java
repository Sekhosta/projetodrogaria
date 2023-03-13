package br.pro.costa.drogaria.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Repository;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
          
public class Produto {
 @Id 
 @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer codigo;
	    @Column(length = 50,nullable = false,unique = true)
 private String nome;
	    @Column(nullable = false)
	    private Byte quantidade;
	    @Column(nullable = false,precision =5 , scale=2)
	    private BigDecimal preco;
	    @Column
	    private LocalDate dataDeValidade;
	   
	    @ManyToOne
	    @JoinColumn(nullable=false)  //corresponde a chave estrangeira forçando valor
	    private Categoria categoria;//A chave estrangeira é um objeto
	}


