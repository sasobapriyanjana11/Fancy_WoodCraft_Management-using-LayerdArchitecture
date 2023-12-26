package lk.ijse.Layerd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
