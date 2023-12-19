package lk.ijse.FancyWoodCraftManagement.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

        private  static lk.ijse.FancyWoodCraftManagement.db.DbConnection dbConnection;
        private Connection connection;

        private DbConnection() throws SQLException {

            connection=  DriverManager.getConnection("jdbc:mysql://localhost:3306/Fancy_WoodCraft_Management",
                    "root",
                    "Ijse@1234");


        }
        public static lk.ijse.FancyWoodCraftManagement.db.DbConnection getInstance() throws SQLException {
            return (null==dbConnection)?dbConnection=new lk.ijse.FancyWoodCraftManagement.db.DbConnection():dbConnection ;
        }

        public Connection getConnection(){return  connection;}

    }

