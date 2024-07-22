package com.example.shop.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @ManyToOne
    @JoinColumn
    private OrderCustomer orderCustomer;
    @ManyToOne
    @JoinColumn
    private Product product;
    @Column
    private int quantity;
    @Column
    private double price;
}
