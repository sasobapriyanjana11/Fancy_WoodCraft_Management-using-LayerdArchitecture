package lk.ijse.FancyWoodCraftManagement.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class OrderDto {
    private String Order_ID;
    private String C_ID;
    private LocalDate date;

}
