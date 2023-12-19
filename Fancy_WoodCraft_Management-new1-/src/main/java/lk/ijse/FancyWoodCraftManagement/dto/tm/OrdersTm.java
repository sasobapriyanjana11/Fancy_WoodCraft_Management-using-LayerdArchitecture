package lk.ijse.FancyWoodCraftManagement.dto.tm;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode

public class OrdersTm {
    private String Order_ID;
    private String C_ID;
    private LocalDate date;
//private String Payment;
   // private String ratings;
}
