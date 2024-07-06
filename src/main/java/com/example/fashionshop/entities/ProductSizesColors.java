package com.example.fashionshop.entities;

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
    private String code;
    @JoinColumn
    @ManyToOne
    private Product product;
    @OneToMany(mappedBy = "productSizesColors", cascade = CascadeType.ALL)
    private List<ProductImage> productImages;
    @JoinColumn
    @ManyToOne
    private Sizes sizes;
    @JoinColumn
    @ManyToOne
    private Colors colors;
    @Column
    private Integer quantity = 0;

}
