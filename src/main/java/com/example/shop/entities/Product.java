package com.example.shop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name = "code", nullable = false, unique = true)
    private String code;
    @Column
    private String name;
    @JoinColumn
    @ManyToOne
    private ProductCategory productCategory;
    @JoinColumn
    private String imgCoverUrl;
    @Column
    private Double price;
    @Column
    private Integer totalQuantity;
    @Column
    private Boolean status;
}
