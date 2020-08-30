package com.tecprime.avaliacaotecprime.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecprime.avaliacaotecprime.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	

}
