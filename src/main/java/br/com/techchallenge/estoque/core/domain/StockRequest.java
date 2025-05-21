package br.com.techchallenge.estoque.core.domain;

import jakarta.validation.constraints.*;

public record StockRequest(
        @NotNull Long productId,
        @NotNull @Min(1) Integer quantity
) {}
