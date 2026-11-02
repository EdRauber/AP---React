package com.example.catalogo.model;

import java.math.BigDecimal;

public record Produto(
    Long id,
    String nome,
    BigDecimal preco,
    String categoria,
    String descricaoString
) {
}