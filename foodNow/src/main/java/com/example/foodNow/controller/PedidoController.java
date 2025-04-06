package com.example.foodNow.controller;



import com.example.foodNow.model.Pedido;
import com.example.foodNow.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    public ResponseEntity<Pedido> criarPedido(Pedido pedido){
        Pedido pedidoCriado = pedidoService.criarPedido(pedido);

        return ResponseEntity.ok(pedidoCriado);
    }
}
