package lk.ijse.Layerd.dao.custom.Impl;


import lk.ijse.Layerd.dao.custom.DeliveryDAO;
import lk.ijse.Layerd.dao.sqlUtil;
import lk.ijse.Layerd.dto.DeliveryDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryModel implements DeliveryDAO {
    @Override
    public boolean save (final DeliveryDto dto) throws SQLException {
      /*  Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Delivery VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, dto.getDelivery_ID());
        preparedStatement.setString(2, dto.getOrder_ID());
        preparedStatement.setString(3,dto.getDelivery_Status());
        preparedStatement.setString(4,dto.getLocation());
        preparedStatement.setString(5, dto.getE_ID());
        preparedStatement.setString(6, dto.getTel());


        boolean isSaved = preparedStatement.executeUpdate() > 0;
        return isSaved;*/
        return sqlUtil.execute("INSERT INTO Delivery VALUES(?,?,?,?,?,?)",dto.getDelivery_ID(),dto.getOrder_ID(),dto.getDelivery_Status(),dto.getLocation(),dto.getE_ID(),dto.getTel());
    }
    @Override
    public boolean update(final DeliveryDto dto) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();
        String sql = "UPDATE Delivery SET Order_ID=?,deliveryStatus=?,Location=?,E_ID=?,tel=? WHERE Delivery_ID=?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1, dto.getOrder_ID());
        preparedStatement.setString(2, dto.getDelivery_Status());
        preparedStatement.setString(3, dto.getLocation());
        preparedStatement.setString(4, dto.getE_ID());
        preparedStatement.setString(5,dto.getTel());
        preparedStatement.setString(6,dto.getDelivery_ID());

        boolean isUpdated = preparedStatement.executeUpdate() > 0;
        return isUpdated;*/
        return sqlUtil.execute("UPDATE Delivery SET Order_ID=?,deliveryStatus=?,Location=?,E_ID=?,tel=? WHERE Delivery_ID=?",dto.getOrder_ID(),dto.getDelivery_Status(), dto.getLocation(),dto.getE_ID(),dto.getTel(),dto.getDelivery_ID());
    }
    @Override
    public boolean delete(String Delivery_ID) throws SQLException {
     /*   Connection connection=DbConnection.getInstance().getConnection();

        String sql="DELETE FROM Delivery WHERE Delivery_ID=?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1,Delivery_ID);

        boolean isDeleted=preparedStatement.executeUpdate()>0;
        return  isDeleted;*/
        return sqlUtil.execute("DELETE FROM Delivery WHERE Delivery_ID=?",Delivery_ID);

    }


    @Override
    public DeliveryDto search(String id) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Delivery WHERE Delivery_ID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet=sqlUtil.execute("SELECT * FROM Delivery WHERE Delivery_ID = ?",id);

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
    @Override
    public List<DeliveryDto> getAll() throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Delivery";
        PreparedStatement pstm = connection.prepareStatement(sql);*/

        List<DeliveryDto> dtoList = new ArrayList<>();

     //   ResultSet resultSet = pstm.executeQuery();

        ResultSet resultSet=sqlUtil.execute("SELECT * FROM Delivery");

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
