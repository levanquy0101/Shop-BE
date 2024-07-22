package com.example.shop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InventoryDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @ManyToOne
    @JoinColumn
    private Inventory inventory;
    @Column
    private String codeProductSizesColors;
    @Column
    private Integer oldQuantity;
    @Column
    private Integer newQuantity;
}
