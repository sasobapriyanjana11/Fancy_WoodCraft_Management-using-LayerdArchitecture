package lk.ijse.FancyWoodCraftManagement.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerTmDis {
    private String C_ID;
    private String name;
    private String address;
    private  String LoyaltyStatus;
    private double discountPercentage;
    private String tel;

}
