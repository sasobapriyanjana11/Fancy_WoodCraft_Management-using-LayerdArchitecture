package lk.ijse.Layerd.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode


public class Customer {
    private String C_ID;
    private String name;
    private  String address;
    private String LoyaltyStatus;
    private String tel;

}
