package br.com.techchallenge.estoque.core.domain;

public record StockResponse(
        Long id,
        Long productId,
        Integer quantity
) {}
