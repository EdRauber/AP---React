package com.example.catalogo.service;

import com.example.catalogo.model.Produto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final List<Produto> produtos = List.of(
        new Produto(
            1L,
            "Teclado mecânico",
            new BigDecimal("249.90"),
            "Periféricos",
            "Teclado com conexão USB."
        ),
        new Produto(
            2L,
            "Mouse sem fio",
            new BigDecimal("89.90"),
            "Periféricos",
            "Mouse compacto e ergonômico."
        ),
        new Produto(
            3L,
            "Monitor 24 polegadas",
            new BigDecimal("799.00"),
            "Monitores",
            "Monitor Full HD."
        ),
        new Produto(
            4L,
            "Webcam HD",
            new BigDecimal("159.00"),
            "Acessórios",
            "Webcam para videoconferências."
        ),
        new Produto(
            5L,
            "Mouse do Rommel",
            new BigDecimal("2"),
            "Lixo",
            "Coisa de veterinário."
        )
    );

    public List<Produto> listar() {
        return produtos;
    }

    public Optional<Produto> buscarPorId(Long id) {
        for (Produto produto : produtos) {
            if (produto.id().equals(id)) {
                return Optional.of(produto);
            }
        }

        return Optional.empty();
    }
}