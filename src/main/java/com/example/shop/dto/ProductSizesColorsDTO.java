package com.example.shop.dto;

import com.example.shop.entities.Colors;
import com.example.shop.entities.Product;
import com.example.shop.entities.ProductImageColor;
import com.example.shop.entities.Sizes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSizesColorsDTO {
    private Product product;
    private List<Sizes> sizes;
    private List<ProductImageColor> productImageColors;
    private Integer quantity;
}
