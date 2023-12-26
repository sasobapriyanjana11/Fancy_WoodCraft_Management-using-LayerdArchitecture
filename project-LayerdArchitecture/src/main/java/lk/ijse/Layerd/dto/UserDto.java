package lk.ijse.Layerd.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode

public class UserDto {

    private String U_ID;
    private String U_Name;
    private String tel;
    private String jobTitle;
    private String password;

}
