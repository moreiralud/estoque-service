package br.com.techchallenge.estoque.core.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stock_items")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class StockItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    @Column(nullable = false)
    private Integer quantity;
}
