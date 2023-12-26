package lk.ijse.Layerd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class OrderDto {
    private String Order_ID;
    private String C_ID;
    private LocalDate date;

}
