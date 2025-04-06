package com.example.foodNow.service;


import com.example.foodNow.model.Produto;
import com.example.foodNow.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto atualizarProduto(Long id, Produto produto) {
        Produto produto1 = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto1.setNome(produto.getNome());
        produto1.setDescricao(produto.getDescricao());
        produto1.setDisponivel(produto.getDisponivel());
        produto1.setPreco(produto.getPreco());

        return produtoRepository.save(produto1);
    }

    /* Mudar a disponibilidade */
    public Produto alterarDisponibilidade(Long id, boolean disponivel){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setDisponivel(disponivel);
        return produtoRepository.save(produto);
    }
}
