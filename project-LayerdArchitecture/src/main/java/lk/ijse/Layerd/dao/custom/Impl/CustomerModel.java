package lk.ijse.Layerd.dao.custom.Impl;

import lk.ijse.FancyWoodCraftManagement.db.DbConnection;
import lk.ijse.FancyWoodCraftManagement.dto.CustomerDto;
import lk.ijse.FancyWoodCraftManagement.dto.tm.CustomerTm;
import lk.ijse.FancyWoodCraftManagement.dto.tm.CustomerTmDis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel {

    public boolean deleteCustomer(final String C_ID) throws SQLException {
        Connection connection= DbConnection.getInstance().getConnection();

        String sql="DELETE  FROM Customer WHERE C_ID=?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1,C_ID);

        boolean isDeleted= preparedStatement.executeUpdate()>0;
        return  isDeleted;

    }

    public boolean saveCustomer(CustomerTmDis dto) throws SQLException {


        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Customer VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, dto.getC_ID());
        preparedStatement.setString(2, dto.getName());
        preparedStatement.setString(3, dto.getAddress());
        preparedStatement.setString(4, dto.getLoyaltyStatus());
        preparedStatement.setString(5, dto.getTel());

        boolean isSaved = preparedStatement.executeUpdate() > 0;
        return isSaved;
    }


    public boolean updateCustomer(CustomerDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "UPDATE Customer  SET name=?,address=?,LoyaltyStatus=?,tel=? WHERE C_ID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, dto.getName());
        preparedStatement.setString(2, dto.getAddress());
        preparedStatement.setString(3, dto.getLoyaltyStatus());
        preparedStatement.setString(4, dto.getTel());
        preparedStatement.setString(5, dto.getC_ID());


        boolean isUpdated = preparedStatement.executeUpdate() > 0;
        return isUpdated;
    }
    public CustomerDto searchCustomer(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Customer WHERE C_ID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();

        CustomerDto dto = null;

        if(resultSet.next()) {
            String cus_id = resultSet.getString(1);
            String cus_name = resultSet.getString(2);
            String cus_address = resultSet.getString(3);
            String cus_tel = resultSet.getString(4);
            String LoyeltyStatus=resultSet.getString(5);

            dto = new CustomerDto(cus_id, cus_name, cus_address, cus_tel,LoyeltyStatus);
        }

        return dto;
    }

    public List<CustomerDto> getAllCustomers() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Customer";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<CustomerDto> dtoList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();

        while (resultSet.next()) {
            String cus_id = resultSet.getString(1);
            String cus_name = resultSet.getString(2);
            String cus_address = resultSet.getString(3);
            String cus_tel = resultSet.getString(4);
            String LoyaltyStatus=resultSet.getString(5);

            var dto = new CustomerDto(cus_id, cus_name, cus_address, cus_tel,LoyaltyStatus);
            dtoList.add(dto);
        }
        return dtoList;
    }
    public List<CustomerTm> loadAllCustomers() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Customer";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        List<CustomerTm> cusList = new ArrayList<>();

        while (resultSet.next()) {
            cusList.add(new CustomerTm(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)


            ));
        }
        return cusList;
    }

}






