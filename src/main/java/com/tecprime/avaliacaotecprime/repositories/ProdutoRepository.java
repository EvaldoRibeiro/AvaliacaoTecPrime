package com.tecprime.avaliacaotecprime.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecprime.avaliacaotecprime.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	

}
