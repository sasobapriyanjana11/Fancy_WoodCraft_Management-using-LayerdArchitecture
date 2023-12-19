package lk.ijse.FancyWoodCraftManagement.model;

import javafx.scene.control.Alert;
import lk.ijse.FancyWoodCraftManagement.db.DbConnection;
import lk.ijse.FancyWoodCraftManagement.dto.tm.ForgetPasswordTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ForgetPasswordModel {
    public ForgetPasswordTm ForgetPasswordTm(String U_ID) throws SQLException {
        Connection connection= DbConnection.getInstance().getConnection();

        String sql="SELECT U_ID,password FROM UserManager WHERE U_ID=?";

        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1,"U_ID");
        preparedStatement.setString(2,"password");

        ResultSet resultSet =preparedStatement.executeQuery();

        ForgetPasswordTm tm =new ForgetPasswordTm();

        if(resultSet.next()) {
            String u_ID = resultSet.getString(1);
            String password = resultSet.getString(2);

            String confirmPassword = tm.getConfirmPassword();
            if (confirmPassword.equals(password)){
                confirmPassword=password;

            }

            tm= new ForgetPasswordTm(u_ID,
                    password,
                    tm.getConfirmPassword(),
                    tm.getEnterOTP(),
                    tm.getSendOTP(),
                    tm.getResetPassword());
        }else{
            new Alert(Alert.AlertType.ERROR,"your confirm password not matched with password,try again!");
        }

        return tm;


    }
}
