package com.example.Shop.models;

import com.example.Shop.models.enums.ProductAvailability;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String type;
    @Column
    private String material;
    @Column
    private double price;
    @Column
    @Enumerated(EnumType.STRING)
    private ProductAvailability availability;
}
