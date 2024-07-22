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
public class ProductImageColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @OneToMany(mappedBy = "productImageColor", cascade = CascadeType.ALL)
    private List<ProductImage> productImages;
    @ManyToOne
    @JoinColumn
    private Colors color;
}
