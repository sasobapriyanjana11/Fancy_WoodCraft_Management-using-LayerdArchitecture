package lk.ijse.Layerd.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.FancyWoodCraftManagement.dto.tm.ForgetPasswordTm;
import lk.ijse.FancyWoodCraftManagement.model.ForgetPasswordModel;

import java.io.IOException;
import java.util.regex.Pattern;

public class ForgetPasswordForm {

        @FXML
        private JFXButton btnResetPassword;

        @FXML
        private JFXButton btnSendOTP;

        @FXML
        private AnchorPane forgetPasswordPane;

        @FXML
        private TextField txtConfirmPasswod;

        @FXML
        private TextField txtEnterOTP;

        @FXML
        private TextField txtPassword;

        @FXML
        private TextField txtUser_ID;

        static int otp;

        @FXML
        void btnResetPasswordOnAction(ActionEvent event) {

        /*    Random random=null;
            otp=random.nextInt(9000);
            otp +=1000;*/

            String pw=   txtPassword.getText();
            String cpw=txtConfirmPasswod.getText();
            String EOTP=txtEnterOTP.getText();
            String U_ID=txtUser_ID.getText();

            var tm=new ForgetPasswordTm(U_ID,pw,cpw,EOTP,btnSendOTP,btnResetPassword);
            var model=new ForgetPasswordModel();

            try{

                if(pw.equals(cpw)&&(!txtEnterOTP.equals(null))&&!U_ID.isEmpty()&&(!pw.isEmpty())&&(!cpw.isEmpty())){

                    new Alert(Alert.AlertType.CONFIRMATION,"password reset successFully").show();

                    Parent root= FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"));
                    Scene scene=new Scene(root);
                    Stage stage=new Stage();
                    stage.setScene(scene);
                    stage.show();

                    Stage stage1=(Stage)forgetPasswordPane.getScene().getWindow();
                    stage1.close();

                }else {
                    new Alert(Alert.AlertType.ERROR,"you should fill all the field to get the new password").show();
                    if (txtUser_ID.equals(null)) {
                        txtUser_ID.requestFocus();
                    } else {
                        if (txtEnterOTP.equals(null)) {
                            txtEnterOTP.requestFocus();
                        } else {
                            if (txtPassword.equals(null)) {

                                txtPassword.requestFocus();
                            } else {
                                if (txtConfirmPasswod.equals(null)) {
                                    txtConfirmPasswod.requestFocus();
                                } else {
                                    btnResetPassword.requestFocus();
                                }
                            }
                        }
                    }

                }

            } catch (IOException e) {
                new Alert(Alert.AlertType.ERROR,e.getMessage()).show();

            }
 }



        @FXML
        void btnSendOTPOnAction(ActionEvent event) {

                String OTP = txtEnterOTP.getText();
                var model = new ForgetPasswordModel();
                try {
                    if (!OTP.isEmpty()) {
                        new Alert(Alert.AlertType.CONFIRMATION, "send OTP\n your OTP is : " + OTP).show();
                    } else {
                        new Alert(Alert.AlertType.ERROR, "you are not type otp").show();
                        txtEnterOTP.requestFocus();
                    }
                } catch (Exception e) {
                    new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
                }

        }

    private boolean isValidDetails() {

        String U_ID= txtUser_ID.getText();
        boolean isU_IDValid= Pattern.matches("[U][0-9]{3,}",U_ID);
        if(!isU_IDValid){
            new Alert(Alert.AlertType.ERROR, "invalid User id  ").show();
            return false;
        }


        String pw= txtPassword.getText();
        boolean isPwValid=Pattern.matches("[0-9]{4}",pw);
        if(!isPwValid){
            new Alert(Alert.AlertType.ERROR, "invalid  password,it include only 4 numeric characters  ").show();
            return false;
        }


         String OTP= txtEnterOTP.getText();
         boolean isOTPValid= Pattern.matches("[A-Za-z0-9]{4}",OTP);
         if(!isOTPValid){
             new Alert(Alert.AlertType.ERROR, "invalid OTP,should have 4 characters and it include at least 1 numeric character  ").show();
             return false;
         }

         String cpw= txtConfirmPasswod.getText();
         boolean isCpwValid=Pattern.matches("[0-9]{4}",cpw);
         if(!isCpwValid){
            new Alert(Alert.AlertType.ERROR, "invalid  confirm password,it include only 4 numeric characters  ").show();
            return false;
        }

            return  true;
    }

    @FXML
        void txtConfirmPasswodOnAction(ActionEvent event) {

            boolean isValidated=isValidDetails();
            if(isValidated) {

                String pw = txtPassword.getText();
                String cpw = txtConfirmPasswod.getText();

                try {

                    if ((pw.isEmpty()) && (!cpw.isEmpty())) {
                        new Alert(Alert.AlertType.ERROR, "password field cannot be blanked");
                        txtPassword.requestFocus();
                    } else if ((!pw.isEmpty()) && (cpw.isEmpty())) {
                        new Alert(Alert.AlertType.ERROR, "Confirm password field cannot be blanked");
                        txtConfirmPasswod.requestFocus();
                    }else if ((!pw.isEmpty()) && ( !cpw.isEmpty()) && (pw.equals(cpw))) {
                        new Alert(Alert.AlertType.CONFIRMATION, "your new password is " + cpw).show();
                    } else {
                        new Alert(Alert.AlertType.ERROR, "not matched with password,try again!").show();
                    }


                } catch (Exception e) {
                    new Alert(Alert.AlertType.ERROR, e.getMessage()).show();


                }
            }

        }

        @FXML
        void txtEnterOTPOnAction(ActionEvent event) {

            boolean isValidated=isValidDetails();
            if(isValidated) {
                String OTP = txtEnterOTP.getText();
                String btn = btnSendOTP.getText();
                if (!OTP.isEmpty()) {
                    new Alert(Alert.AlertType.INFORMATION, "if it is OTP,then click SendOtp button" + btn).show();
                    btnSendOTP.requestFocus();
                } else {
                    new Alert(Alert.AlertType.ERROR, "You should fill this field").show();
                }
            }

        }

        @FXML
        void txtPasswordOnAction(ActionEvent event) {

            boolean isPasswordValidated=isValidDetails();
            if(isPasswordValidated) {
                String pw = txtPassword.getText();
                String cpw = txtConfirmPasswod.getText();
                if (!pw.isEmpty()) {
                    txtPassword.requestFocus();
                 //   txtConfirmPasswodOnAction(new ActionEvent());
                } else {
                    new Alert(Alert.AlertType.ERROR, "you should fill this field to login your system").show();
                }
            }

        }

        @FXML
        void txtUser_IDOnAction(ActionEvent event) {

            boolean isU_IDValidated = isValidDetails();
            if (isU_IDValidated) {
                String U_ID = txtUser_ID.getText();
                var model = new ForgetPasswordModel();

                try {
                    ForgetPasswordTm forgetPasswordTm = model.ForgetPasswordTm(U_ID);
                    if (!forgetPasswordTm.equals(null)) {
                        new Alert(Alert.AlertType.CONFIRMATION, "U_ID is correct").show();
                    } else {
                        new Alert(Alert.AlertType.ERROR, "U_ID is not matched ,try again").show();
                    }
                } catch (Exception e) {
                    new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
                }

            }
        }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)forgetPasswordPane.getScene().getWindow();
        stage1.close();
    }
}


