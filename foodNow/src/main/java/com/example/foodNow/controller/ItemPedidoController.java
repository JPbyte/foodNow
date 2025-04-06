package com.example.foodNow.controller;

import com.example.foodNow.model.ItemPedido;
import com.example.foodNow.service.ItemPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
@RequiredArgsConstructor
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    @PostMapping("/adicionar")
    public ResponseEntity<ItemPedido> adicionarItem(@RequestParam Long pedidoId,
                                                    @RequestParam Long produtoId,
                                                    @RequestParam int quantidade) {
        ItemPedido item = itemPedidoService.adicionarItem(pedidoId, produtoId, quantidade);
        return ResponseEntity.ok(item);
    }

    @GetMapping("/pedido/{pedidoId}")
    public ResponseEntity<List<ItemPedido>> listarItens(@PathVariable Long pedidoId) {
        List<ItemPedido> itens = itemPedidoService.listarItensPorPedido(pedidoId);
        return ResponseEntity.ok(itens);
    }
}