package com.tecprime.avaliacaotecprime;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tecprime.avaliacaotecprime.domain.Categoria;
import com.tecprime.avaliacaotecprime.repositories.CategoriaRepository;

@SpringBootApplication
public class AvalicaotecprimeApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AvalicaotecprimeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Bebidas");
		Categoria cat2 = new Categoria(null, "Alimentação");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
	}

}
