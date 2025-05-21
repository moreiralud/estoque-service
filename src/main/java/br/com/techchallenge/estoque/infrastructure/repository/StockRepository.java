package br.com.techchallenge.estoque.infrastructure.repository;

import br.com.techchallenge.estoque.core.domain.StockItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<StockItem, Long> {
    Optional<StockItem> findByProductId(Long productId);
}
