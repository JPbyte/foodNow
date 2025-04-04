package com.example.foodNow.repository;

import com.example.foodNow.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository {
    List<Produto> findByNome(String nome);
}
