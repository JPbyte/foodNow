package com.example.foodNow.service;

import com.example.foodNow.model.Pedido;
import com.example.foodNow.model.PedidoStatus;
import com.example.foodNow.repository.PedidoRepository;
import com.example.foodNow.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;

    public Pedido criarPedido(Pedido pedido){

        /* Todo pedido começa com o status recebido */

        pedido.setStatus(PedidoStatus.RECEBIDO);
        pedido.setDataTime(LocalDateTime.now());

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos(PedidoStatus status){
        /* Caso o status não for nulo, ele filtra os pedidos
         * Se for nulo ele retorna todos os pedidos
        */

        if(status != null){
            return pedidoRepository.findByStatus(status);
        } else {
            return pedidoRepository.findAll();
        }
    }

    public Pedido atualizarPedido(Long id, PedidoStatus status){
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        pedido.setStatus(status);

        return pedidoRepository.save(pedido);
    }
}
