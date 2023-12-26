package lk.ijse.Layerd.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode

public class EmployeeDto {

    private String E_ID;
    private String name;
    private String jobTitle;
    private String tel;
}
