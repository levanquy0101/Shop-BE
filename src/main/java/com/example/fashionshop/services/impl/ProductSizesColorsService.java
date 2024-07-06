package com.example.fashionshop.services.impl;

import com.example.fashionshop.dto.ProductSizesColorsDTO;
import com.example.fashionshop.entities.Colors;
import com.example.fashionshop.entities.Product;
import com.example.fashionshop.entities.ProductSizesColors;
import com.example.fashionshop.entities.Sizes;
import com.example.fashionshop.repositories.IProductRepo;
import com.example.fashionshop.repositories.IProductSizesColorsRepo;
import com.example.fashionshop.services.IProductSizesColorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSizesColorsService implements IProductSizesColorsService {
    @Autowired
    private IProductSizesColorsRepo iProductSizesColorsRepo;
    @Autowired
    private IProductRepo iProductRepo;

    @Override
    public List<ProductSizesColors> findAllProductSizesColors() {
        return iProductSizesColorsRepo.findAll();
    }

    @Override
    public Page<ProductSizesColors> getProductSizesColors(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return iProductSizesColorsRepo.findAllProductSizesColors(pageable);
    }

    @Override
    public void createProductSizesColors(ProductSizesColorsDTO productSizesColorsDTO) {
        Product product = productSizesColorsDTO.getProduct();
        iProductRepo.save(product);
        Product productNew = iProductRepo.findByCode(product.getCode());

        List<Sizes> sizes = productSizesColorsDTO.getSizes();
        List<Colors> colors = productSizesColorsDTO.getColors();
        Integer quantity = 0;

        for (Sizes size : sizes) {
            for (Colors color : colors) {
                ProductSizesColors productSizesColors = new ProductSizesColors();
                productSizesColors.setProduct(productNew);
                productSizesColors.setSizes(size);
                productSizesColors.setColors(color);
                productSizesColors.setQuantity(quantity);

                // Lưu ProductSizesColors
                iProductSizesColorsRepo.save(productSizesColors);
            }
        }

    }

    @Override
    public ProductSizesColors findByCode(String code) {
        return iProductSizesColorsRepo.findByCode(code);
    }

}

