package lk.ijse.Layerd.view.tdm;

import lombok.*;

import java.time.LocalDate;

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
