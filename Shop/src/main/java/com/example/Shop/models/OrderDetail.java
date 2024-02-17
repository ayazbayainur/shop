package com.example.Shop.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order orderId;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;
    @Column
    private Integer quantity;
    @Column(name = "total_price")
    private double totalPrice;
    @Column
    private String status;
}
