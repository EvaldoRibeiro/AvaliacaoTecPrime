package com.tecprime.avaliacaotecprime;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tecprime.avaliacaotecprime.domain.Categoria;
import com.tecprime.avaliacaotecprime.domain.Produto;
import com.tecprime.avaliacaotecprime.repositories.CategoriaRepository;
import com.tecprime.avaliacaotecprime.repositories.ProdutoRepository;

@SpringBootApplication
public class AvalicaotecprimeApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AvalicaotecprimeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Bebidas");
		Categoria cat2 = new Categoria(null, "Alimentação");
		
		Produto p1 = new Produto(null, "Hambúrgueres", 20.00);
		Produto p2 = new Produto(null, "Porções", 80.00);
		Produto p3 = new Produto(null, "Sucos", 8.00);
		Produto p4 = new Produto(null, "Refrigerantes", 12.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2));
		cat2.getProdutos().addAll(Arrays.asList(p3, p4));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
	}

}
