package lk.ijse.FancyWoodCraftManagement.model;

import lk.ijse.FancyWoodCraftManagement.db.DbConnection;
import lk.ijse.FancyWoodCraftManagement.dto.UserDto;
import lk.ijse.FancyWoodCraftManagement.dto.tm.UserLOGINTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginModel {
    public boolean searchUserPassword(String pw) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM UserManager WHERE password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,pw);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }
    public boolean searchUserUserName(String Uname) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM UserManager WHERE U_Name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, Uname);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }
}
