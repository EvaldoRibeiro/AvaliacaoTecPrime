package com.tecprime.avaliacaotecprime.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecprime.avaliacaotecprime.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
	

}
