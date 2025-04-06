package com.example.foodNow.service;

import com.example.foodNow.model.ItemPedido;
import com.example.foodNow.model.Pedido;
import com.example.foodNow.model.Produto;
import com.example.foodNow.repository.ItemPedidoRepository;
import com.example.foodNow.repository.PedidoRepository;
import com.example.foodNow.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;

    public ItemPedido adicionarItem(Long pedidoId, Long produtoId, int quantidade) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        ItemPedido item = new ItemPedido();
        item.setPedido(pedido);
        item.setProduto(produto);
        item.setQuantidade(quantidade);

        return itemPedidoRepository.save(item);
    }

    public List<ItemPedido> listarItensPorPedido(Long pedidoId) {
        return itemPedidoRepository.findByPedidoId(pedidoId);
    }
}
