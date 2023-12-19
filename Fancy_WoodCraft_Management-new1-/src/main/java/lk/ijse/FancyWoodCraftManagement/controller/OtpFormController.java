package lk.ijse.FancyWoodCraftManagement.controller;

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

import java.io.IOException;

public class OtpFormController {

    @FXML
    private AnchorPane OtpForm;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnVerify;

    @FXML
    private TextField txtOtp;
    private OtpFormController ForgotPasswordForm;

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/ForgetPasswordForm.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stage1=(Stage)OtpForm.getScene().getWindow();
        stage1.close();

    }
    private  int otp;
    @FXML
    void btnVerifyOnAction(ActionEvent event) throws IOException {
        System.out.println(ForgetPasswordForm.otp);
        if(String.valueOf(otp).equals(txtOtp.getText())){
            btnVerify.getScene().getWindow().hide();

            Parent root= FXMLLoader.load(this.getClass().getResource("/view/ForgetPasswordForm.fxml"));
            Scene scene=new Scene(root);
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.show();

            Stage stage1=(Stage)OtpForm.getScene().getWindow();
            stage1.close();

        }else{
            new Alert(Alert.AlertType.ERROR,"OTP WRONG");
        }

    }

    @FXML
    void txtOtpOnAction(ActionEvent event) {}

    public void initialize(){
        System.out.println(ForgotPasswordForm.otp);
        this.otp = ForgotPasswordForm.otp;
    }

}



