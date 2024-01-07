package lk.ijse.Layerd.Controller;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.Layerd.dao.custom.Impl.LoginImpl;


import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {

        @FXML
        private Button btnForgetPassword;

        @FXML
        private JFXButton btnLogin;

        @FXML
        private AnchorPane loginPane;

        @FXML
        private TextField txtPassword;

        @FXML
        private Label txtSignIn;

        @FXML
        private TextField txtUserName;

        @FXML
        void btnForgetPasswordOnAction(ActionEvent event) throws IOException {
            Parent root=FXMLLoader.load(this.getClass().getResource("/view/ForgetPasswordForm.fxml"));
            Scene scene=new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage stage1 = (Stage) loginPane.getScene().getWindow();
            stage1.close();

        }

        @FXML
        void btnLoginOnAction(ActionEvent event) throws IOException, SQLException {
            String name = txtUserName.getText();
            String password = txtPassword.getText();
            LoginImpl loginModelModel = new LoginImpl();
            boolean isvalidUserName =loginModelModel.searchUserUserName(name);

            boolean isvalidPassword =loginModelModel.searchUserPassword(password);

            if(!isvalidUserName) {
                new Alert(Alert.AlertType.ERROR, "Invalid User name Please Try Again!!!").show();
                txtUserName.setStyle("-fx-border-color:#ff0000;");
            } else if (!isvalidPassword) {
                new Alert(Alert.AlertType.ERROR, "Invalid Password Please Try Again!!!").show();
                txtPassword.setStyle("-fx-border-color:#ff0000;");
            } else {
                Parent root= FXMLLoader.load(this.getClass().getResource("/view/DashBoardForm.fxml"));
                Scene scene=new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                Stage stage1 = (Stage) loginPane.getScene().getWindow();
                stage1.close();

            }

        }

        @FXML
        void txtPasswordOnAction(ActionEvent event) {
        }

        @FXML
        void txtUserNameOnAction(ActionEvent event) {
    }

}



