package com.example.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDTO {
    private String code;
    private String codeEmployee;
    private LocalDate date;
    private List<InventoryDetailDTO> inventoryDetails = new ArrayList<>();
}
