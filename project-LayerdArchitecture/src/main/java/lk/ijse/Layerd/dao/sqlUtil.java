package lk.ijse.Layerd.dao;


import lk.ijse.Layerd.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sqlUtil {
 public static  <T> T execute(String sql,Object ... args) throws SQLException {

   Connection connection= DbConnection.getInstance().getConnection();
     PreparedStatement pstm=connection.prepareStatement(sql);
     for(int i=0;i< args.length;i++){
         pstm.setObject(i+1,args[i]);

     }
     if(sql.startsWith("SELECT")){
         return (T) pstm.executeQuery();
     }
     else {
         return (T) (Boolean) (pstm.executeUpdate()>0);
     }
 }
}
