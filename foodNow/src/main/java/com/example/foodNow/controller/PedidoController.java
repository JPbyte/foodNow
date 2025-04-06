package com.example.foodNow.controller;



import com.example.foodNow.model.Pedido;
import com.example.foodNow.model.PedidoStatus;
import com.example.foodNow.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping("/criar")
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido){
        Pedido pedidoCriado = pedidoService.criarPedido(pedido);

        return ResponseEntity.ok(pedidoCriado);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Pedido>> listarPedidos(@RequestParam(required = false) PedidoStatus status){
        List<Pedido> pedidos = pedidoService.listarPedidos(status);

        return ResponseEntity.ok(pedidos);
    }

    @PatchMapping("{id}/status")
    public ResponseEntity<Pedido> atualizarStatus(@PathVariable Long id, @RequestBody PedidoStatus status){
        Pedido pedidoAtualizado = pedidoService.atualizarPedido(id, status);

        return ResponseEntity.ok(pedidoAtualizado);
    }
}
