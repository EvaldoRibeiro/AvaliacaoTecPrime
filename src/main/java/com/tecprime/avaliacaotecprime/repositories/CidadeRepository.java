package com.tecprime.avaliacaotecprime.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecprime.avaliacaotecprime.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
	

}
