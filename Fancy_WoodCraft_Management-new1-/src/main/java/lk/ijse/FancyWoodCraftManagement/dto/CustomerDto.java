package lk.ijse.FancyWoodCraftManagement.dto;
import  lk.ijse.FancyWoodCraftManagement.dto.tm.LoyaltyStatusTm;
import lk.ijse.FancyWoodCraftManagement.dto.tm.CustomerTm;
import lk.ijse.FancyWoodCraftManagement.model.CustomerModel;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
