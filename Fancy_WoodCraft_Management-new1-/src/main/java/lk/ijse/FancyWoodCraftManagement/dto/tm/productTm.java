package lk.ijse.FancyWoodCraftManagement.dto.tm;

import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class productTm{
    private String Product_ID;
    private  String name;
    private  String Description;
    private double Price;
    private Integer  Quantity_On_Stock;


}
