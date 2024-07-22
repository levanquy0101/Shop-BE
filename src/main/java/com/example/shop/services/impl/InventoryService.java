package com.example.shop.services.impl;

import com.example.shop.dto.InventoryDTO;
import com.example.shop.dto.InventoryDetailDTO;
import com.example.shop.entities.Inventory;
import com.example.shop.entities.InventoryDetail;
import com.example.shop.entities.ProductSizesColors;
import com.example.shop.exceptions.HttpExceptions;
import com.example.shop.repositories.IInventoryDetailRepo;
import com.example.shop.repositories.IInventoryRepo;
import com.example.shop.repositories.IProductSizesColorsRepo;
import com.example.shop.services.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InventoryService implements IInventoryService {
    @Autowired
    private IInventoryRepo iInventoryRepo;

    @Autowired
    private IInventoryDetailRepo iInventoryDetailRepo;

    @Autowired
    private IProductSizesColorsRepo iProductSizesColorsRepo;

    @Override
    public void createInventory(InventoryDTO inventoryDTO) {
        Inventory inventory = new Inventory();
        inventory.setCode(inventoryDTO.getCode());
        inventory.setCodeEmployee(inventoryDTO.getCodeEmployee());
        inventory.setDate(new Date());
        System.out.println(new Date().toString());
        Inventory savedInventory = iInventoryRepo.save(inventory);

        List<InventoryDetailDTO> inventoryDetailsDTO = inventoryDTO.getInventoryDetails();

        for (InventoryDetailDTO inventoryDetailDTO : inventoryDetailsDTO) {
            InventoryDetail inventoryDetail = new InventoryDetail();
            inventoryDetail.setCodeProductSizesColors(inventoryDetailDTO.getCodeProductSizesColors());
            ProductSizesColors productSizesColors = iProductSizesColorsRepo.findByCode(inventoryDetailDTO.getCodeProductSizesColors());
            if (productSizesColors != null) {
                int oldQuantity = productSizesColors.getQuantity();
                int newQuantity = inventoryDetailDTO.getNewQuantity();

                // Nếu số lượng cũ bằng số lượng mới thì không lưu InventoryDetail
                if (oldQuantity == newQuantity) {
                    throw new HttpExceptions.SameQuantityException("Số lượng cũ và mới không được bằng nhau cho sản phẩm: " + inventoryDetailDTO.getCodeProductSizesColors());
                }

                inventoryDetail.setOldQuantity(productSizesColors.getQuantity());
                productSizesColors.setQuantity(inventoryDetailDTO.getNewQuantity());
            }
            inventoryDetail.setNewQuantity(inventoryDetailDTO.getNewQuantity());
            inventoryDetail.setInventory(savedInventory);

            iInventoryDetailRepo.save(inventoryDetail);
        }
    }
}
