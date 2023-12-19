package lk.ijse.FancyWoodCraftManagement.dto.tm;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class CustomerTm {
    private String C_ID;
    private String name;
    private  String address;
   // private String LoyaltyStatus="new customer";
    private String tel;



}

