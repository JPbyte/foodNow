package com.example.foodNow.repository;

import com.example.foodNow.model.Pedido;
import com.example.foodNow.model.PedidoStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByStatus(PedidoStatus status);
}
