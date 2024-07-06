package com.example.fashionshop.services;

import com.example.fashionshop.dto.ProductSizesColorsDTO;
import com.example.fashionshop.entities.ProductSizesColors;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface IProductSizesColorsService {
    List<ProductSizesColors> findAllProductSizesColors();
    Page<ProductSizesColors> getProductSizesColors(int page, int size);

    void createProductSizesColors(ProductSizesColorsDTO productSizesColorsDTO);

    ProductSizesColors findByCode(String code);
}
