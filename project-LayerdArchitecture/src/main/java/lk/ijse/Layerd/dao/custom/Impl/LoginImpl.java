package lk.ijse.Layerd.dao.custom.Impl;



import lk.ijse.Layerd.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginImpl {
    public boolean searchUserPassword(String pw) throws SQLException {
     Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM UserManager WHERE password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,pw);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();

       // return sqlUtil.execute("SELECT * FROM UserManager WHERE password = ?",pw);
    }
    public boolean searchUserUserName(String Uname) throws SQLException {
      Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM UserManager WHERE U_Name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, Uname);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();

       // return  sqlUtil.execute("SELECT * FROM UserManager WHERE U_Name = ?",Uname);
    }
}
