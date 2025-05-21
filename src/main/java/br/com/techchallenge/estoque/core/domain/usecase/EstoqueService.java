package br.com.techchallenge.estoque.core.domain.usecase;

import br.com.techchallenge.estoque.core.domain.*;
import br.com.techchallenge.estoque.infrastructure.repository.StockRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EstoqueService {

    private final StockRepository repo;

    /** Entrada de estoque (somar quantidade). */
    @Transactional
    public StockItem add(StockRequest dto) {
        StockItem item = repo.findByProductId(dto.productId())
                .orElse(StockItem.builder()
                        .productId(dto.productId())
                        .quantity(0)
                        .build());

        item.setQuantity(item.getQuantity() + dto.quantity());
        return repo.save(item);
    }

    /** Reserva / baixa de estoque. */
    @Transactional
    public StockItem reserve(Long productId, Integer qtd) {
        StockItem item = repo.findByProductId(productId)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));

        if (item.getQuantity() < qtd) throw new IllegalStateException("Estoque insuficiente");

        item.setQuantity(item.getQuantity() - qtd);
        return repo.save(item);
    }
}
