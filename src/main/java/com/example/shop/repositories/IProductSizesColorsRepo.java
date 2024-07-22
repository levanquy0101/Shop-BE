package com.example.shop.repositories;

import com.example.shop.entities.ProductSizesColors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IProductSizesColorsRepo extends JpaRepository<ProductSizesColors, Long> {

    @Query(value = "SELECT * FROM product_sizes_colors WHERE quantity >= 0 ORDER BY id DESC", nativeQuery = true)
    Page<ProductSizesColors> findAllProductSizesColors(Pageable pageable);
    
    ProductSizesColors findByCode(String code);
}
