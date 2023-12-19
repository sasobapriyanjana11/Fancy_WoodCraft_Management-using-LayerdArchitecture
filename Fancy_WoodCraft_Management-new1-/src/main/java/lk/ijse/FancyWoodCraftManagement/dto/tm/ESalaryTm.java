package lk.ijse.FancyWoodCraftManagement.dto.tm;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString

public class ESalaryTm {
    private String Salary_ID;
    private String E_ID;
  //  private String tel;
    private String date;
    private double Payment;

}