package com.tecprime.avaliacaotecprime.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecprime.avaliacaotecprime.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	

}
