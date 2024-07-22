package com.example.shop.services.impl;

import com.example.shop.dto.ProductSizesColorsDTO;
import com.example.shop.entities.*;
import com.example.shop.repositories.IProductImageColorRepo;
import com.example.shop.repositories.IProductImageRepo;
import com.example.shop.repositories.IProductRepo;
import com.example.shop.repositories.IProductSizesColorsRepo;
import com.example.shop.services.IProductSizesColorsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductSizesColorsService implements IProductSizesColorsService {
    @Autowired
    private IProductSizesColorsRepo iProductSizesColorsRepo;
    @Autowired
    private IProductRepo iProductRepo;
    @Autowired
    private IProductImageColorRepo iProductImageColorRepo;
    @Autowired
    private IProductImageRepo iProductImageRepo;

    @Override
    public List<ProductSizesColors> findAllProductSizesColors() {
        return iProductSizesColorsRepo.findAll();
    }

    @Override
    public Page<ProductSizesColors> getProductSizesColors(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return iProductSizesColorsRepo.findAllProductSizesColors(pageable);
    }

//    }
@Override
@Transactional
public void createProductSizesColors(ProductSizesColorsDTO productSizesColorsDTO) {
    // Lưu sản phẩm
    Product product = productSizesColorsDTO.getProduct();
    iProductRepo.save(product);
    Product productNew = iProductRepo.findByCode(product.getCode());

    List<ProductImageColor> productImageColorsDTO = productSizesColorsDTO.getProductImageColors();
    iProductImageColorRepo.saveAll(productImageColorsDTO);

    List<ProductImage> productImages = productImageColorsDTO.stream()
            .flatMap(productImageColor -> {
                if (productImageColor != null) {
                    return productImageColor.getProductImages().stream();
                } else {
                    return Stream.empty(); // Trả về một luồng rỗng nếu productImageColor là null
                }
            })
            .distinct()
            .collect(Collectors.toList());

    // Đảm bảo rằng các mối quan hệ đã được thiết lập trước khi lưu
    productImages.forEach(productImage -> {
        if (productImage.getProductImageColor() == null) {
            // Gán mối quan hệ nếu chưa được thiết lập
            productImage.setProductImageColor(productImageColorsDTO.stream()
                    .filter(pic -> pic.getProductImages().contains(productImage))
                    .findFirst()
                    .orElse(null));
        }
    });


    // Lưu ProductSizesColors
    List<Sizes> sizes = productSizesColorsDTO.getSizes();
//    List<ProductImageColor> productImageColorsFromDTO = productSizesColorsDTO.getProductImageColors();
    Integer quantity = 0;

    for (Sizes size : sizes) {
        for (ProductImageColor productImageColor : productImageColorsDTO) {
            ProductSizesColors productSizesColors = new ProductSizesColors();
            productSizesColors.setName(productNew.getName() + " size " + size.getName() + " màu " + productImageColor.getColor().getName());
            productSizesColors.setProduct(productNew);
            productSizesColors.setSizes(size);
            productSizesColors.setProductImageColor(productImageColor);
            productSizesColors.setQuantity(quantity);

            // Lưu ProductSizesColors
            iProductSizesColorsRepo.saveAndFlush(productSizesColors);

            // Cập nhật mã sản phẩm mới
            String newCode = "PSC" + String.format("%03d", productSizesColors.getId());
            productSizesColors.setCode(newCode);

            // Cập nhật mã sản phẩm mới
            iProductSizesColorsRepo.save(productSizesColors);
        }
    }
}

    @Override
    public ProductSizesColors findByCode(String code) {
        return iProductSizesColorsRepo.findByCode(code);
    }

}

