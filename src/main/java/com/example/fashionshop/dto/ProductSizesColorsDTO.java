package com.example.fashionshop.dto;

import com.example.fashionshop.entities.Colors;
import com.example.fashionshop.entities.Product;
import com.example.fashionshop.entities.ProductImage;
import com.example.fashionshop.entities.Sizes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSizesColorsDTO {
    private Product product;
//    private List<ProductImage> productImages;
    private List<Sizes> sizes;
    private List<Colors> colors;
    private Integer quantity;
}
