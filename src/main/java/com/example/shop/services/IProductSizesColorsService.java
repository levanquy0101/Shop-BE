package com.example.shop.services;

import com.example.shop.dto.ProductSizesColorsDTO;
import com.example.shop.entities.ProductSizesColors;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProductSizesColorsService {
    List<ProductSizesColors> findAllProductSizesColors();
    Page<ProductSizesColors> getProductSizesColors(int page, int size);

    void createProductSizesColors(ProductSizesColorsDTO productSizesColorsDTO);

    ProductSizesColors findByCode(String code);
}
