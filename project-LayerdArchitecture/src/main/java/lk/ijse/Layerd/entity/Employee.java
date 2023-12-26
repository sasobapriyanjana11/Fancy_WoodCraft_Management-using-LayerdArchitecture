package lk.ijse.Layerd.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode

public class Employee {

    private String E_ID;
    private String name;
    private String jobTitle;
    private String tel;
}
