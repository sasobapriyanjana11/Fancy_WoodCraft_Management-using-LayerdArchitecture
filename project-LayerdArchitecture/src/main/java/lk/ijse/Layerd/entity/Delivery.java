package lk.ijse.Layerd.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Delivery {
    private  String Delivery_ID;
    private String Order_ID;
    private String delivery_Status;
    private  String Location;
    private  String E_ID;
    private String Tel;


}
