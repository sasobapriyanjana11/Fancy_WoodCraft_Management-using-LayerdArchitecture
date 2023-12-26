package lk.ijse.Layerd.entity;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode

public class User {

    private String U_ID;
    private String U_Name;
    private String tel;
    private String jobTitle;
    private String password;

}
