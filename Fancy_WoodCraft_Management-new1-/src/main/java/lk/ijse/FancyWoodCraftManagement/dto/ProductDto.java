package lk.ijse.FancyWoodCraftManagement.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ProductDto {
    private String Product_ID;
    private  String name;
    private  String Description;
    private double Price;
   // private int QTY;
    private int QuantityOnStock;
}
