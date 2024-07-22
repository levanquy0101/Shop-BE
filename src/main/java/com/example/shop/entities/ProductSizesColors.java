package com.example.shop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductSizesColors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String code;
    @JoinColumn
    @ManyToOne
    private Product product;
    @JoinColumn
    @ManyToOne
    private Sizes sizes;
    @JoinColumn
    @ManyToOne
    private ProductImageColor productImageColor;
    @Column
    private Integer quantity = 0;
    @Column
    private String qrCode;
}
