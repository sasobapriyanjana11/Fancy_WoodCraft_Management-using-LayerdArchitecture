package lk.ijse.Layerd.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode


public class CustomerDto {
    private String C_ID;
    private String name;
    private  String address;
    private String LoyaltyStatus;
    private String tel;



}
