package lk.ijse.FancyWoodCraftManagement.dto.tm;

import javafx.scene.control.Button;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode

public class UserLOGINTm {
    //login info
    private String Password;
    private String U_Name;
    private Button Login;
    // private Button SignUp;
    private Button ForgetPassword;
}
