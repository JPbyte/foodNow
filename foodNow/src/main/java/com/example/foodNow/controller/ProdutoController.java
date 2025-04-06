package com.example.foodNow.controller;


import com.example.foodNow.model.Produto;
import com.example.foodNow.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto){
        Produto novoProduto = produtoService.salvarProduto(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Produto>> listarProdutos(){
        List<Produto> produtos = produtoService.listarProdutos();

        return ResponseEntity.ok(produtos);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto){
        Produto produtoAtualizado = produtoService.atualizarProduto(id, produto);

        return ResponseEntity.ok(produtoAtualizado);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Produto> alterarStatus(@PathVariable Long id, @RequestBody Produto produto){
        Produto produtoAlterado = produtoService.alterarDisponibilidade(id, produto.getDisponivel());

        return ResponseEntity.ok(produtoAlterado);
    }
}
