package lk.ijse.FancyWoodCraftManagement.dto.tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode

public class DeliveryTm {
    private  String Delivery_ID;
    private String Order_ID;
    private String deliveryStatus;
    private  String Location;
    private  String E_ID;
}