package lk.ijse.FancyWoodCraftManagement.model;

import lk.ijse.FancyWoodCraftManagement.db.DbConnection;
import lk.ijse.FancyWoodCraftManagement.dto.CustomerDto;
import lk.ijse.FancyWoodCraftManagement.dto.DeliveryDto;
import lk.ijse.FancyWoodCraftManagement.dto.SupplierDto;
import lk.ijse.FancyWoodCraftManagement.dto.tm.DeliveryTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryModel {
    public boolean saveDeliveryDetails (final DeliveryDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Delivery VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, dto.getDelivery_ID());
        preparedStatement.setString(2, dto.getOrder_ID());
        preparedStatement.setString(3,dto.getDelivery_Status());
        preparedStatement.setString(4,dto.getLocation());
        preparedStatement.setString(5, dto.getE_ID());
        preparedStatement.setString(6, dto.getTel());



        boolean isSaved = preparedStatement.executeUpdate() > 0;
        return isSaved;
    }

    public boolean updateDeliveryDetails(final DeliveryDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "UPDATE Delivery SET Order_ID=?,deliveryStatus=?,Location=?,E_ID=?,tel=? WHERE Delivery_ID=?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1, dto.getOrder_ID());
        preparedStatement.setString(2, dto.getDelivery_Status());
        preparedStatement.setString(3, dto.getLocation());
        preparedStatement.setString(4, dto.getE_ID());
        preparedStatement.setString(5,dto.getTel());
        preparedStatement.setString(6,dto.getDelivery_ID());

        boolean isUpdated = preparedStatement.executeUpdate() > 0;
        return isUpdated;
    }
    public boolean deleteDelivery(String Delivery_ID) throws SQLException {
        Connection connection=DbConnection.getInstance().getConnection();

        String sql="DELETE FROM Delivery WHERE Delivery_ID=?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1,Delivery_ID);

        boolean isDeleted=preparedStatement.executeUpdate()>0;
        return  isDeleted;

    }



    public DeliveryDto searchDelivery(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Delivery WHERE Delivery_ID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();

        DeliveryDto dto = null;

        if(resultSet.next()) {
            String delivery_ID = resultSet.getString(1);
            String order_ID = resultSet.getString(2);
            String delivery_Status = resultSet.getString(3);
            String location = resultSet.getString(4);
            String E_ID=resultSet.getString(5);
            String tel=resultSet.getString(6);

            dto = new DeliveryDto(delivery_ID,order_ID,delivery_Status,location,E_ID,tel);
        }

        return dto;
    }

    public List<DeliveryDto> getAllDelivery() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Delivery";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<DeliveryDto> dtoList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();

        while (resultSet.next()) {
            String delivery_ID = resultSet.getString(1);
            String order_ID = resultSet.getString(2);
            String delivery_Status = resultSet.getString(3);
            String location = resultSet.getString(4);
            String E_ID=resultSet.getString(5);
            String tel=resultSet.getString(6);


            var dto = new DeliveryDto(delivery_ID,order_ID,delivery_Status,location,E_ID,tel);
            dtoList.add(dto);
        }
        return dtoList;
    }

}
