package lk.ijse.Layerd.view.tdm;

import javafx.scene.control.Button;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode

public class ForgetPasswordTm {

    private String U_ID;
    private String password;
    private String ConfirmPassword;
    private String EnterOTP;
    private Button sendOTP;
    private Button ResetPassword;
}
