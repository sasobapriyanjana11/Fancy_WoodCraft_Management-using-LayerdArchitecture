package lk.ijse.Layerd.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class DeliveryDto {
    private  String Delivery_ID;
    private String Order_ID;
    private String delivery_Status;
    private  String Location;
    private  String E_ID;
    private String Tel;


}
