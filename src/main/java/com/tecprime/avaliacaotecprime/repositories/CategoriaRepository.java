package com.tecprime.avaliacaotecprime.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecprime.avaliacaotecprime.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	

}
