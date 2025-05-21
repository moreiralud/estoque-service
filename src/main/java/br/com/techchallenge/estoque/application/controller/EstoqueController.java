package br.com.techchallenge.estoque.application.controller;

import br.com.techchallenge.estoque.core.domain.*;
import br.com.techchallenge.estoque.core.domain.usecase.EstoqueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estoque")
@RequiredArgsConstructor
public class EstoqueController {

    private final EstoqueService service;

    /** Entrada de estoque. */
    @PostMapping
    public ResponseEntity<StockResponse> entrada(@RequestBody @Valid StockRequest req) {
        return ResponseEntity.ok(toResp(service.add(req)));
    }

    /** Reserva (baixa) de estoque. */
    @PostMapping("/{productId}/reserva")
    public ResponseEntity<StockResponse> reserva(
            @PathVariable Long productId,
            @RequestParam Integer qtd) {

        return ResponseEntity.ok(toResp(service.reserve(productId, qtd)));
    }

    private StockResponse toResp(StockItem i) {
        return new StockResponse(i.getId(), i.getProductId(), i.getQuantity());
    }
}
