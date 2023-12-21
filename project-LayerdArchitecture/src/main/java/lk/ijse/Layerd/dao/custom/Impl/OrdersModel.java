package lk.ijse.Layerd.dao.custom.Impl;

import lk.ijse.FancyWoodCraftManagement.db.DbConnection;
import lk.ijse.FancyWoodCraftManagement.dto.OrderDto;
import lk.ijse.FancyWoodCraftManagement.dto.tm.OrdersTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdersModel {
    public boolean saveOrders(final OrdersTm Tm) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Orders (Order_ID,date,C_ID) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, Tm.getOrder_ID());
        preparedStatement.setString(2, String.valueOf(Tm.getDate()));
        preparedStatement.setString(3, Tm.getC_ID());
        boolean isSaved = preparedStatement.executeUpdate() > 0;
        return isSaved;
    }

    public boolean updateOrders(OrdersTm Tm) throws SQLException {


        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE Orders  SET date=?,C_ID=? WHERE Order_ID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, String.valueOf(Tm.getDate()));
        preparedStatement.setString(2, Tm.getC_ID());
        preparedStatement.setString(3, Tm.getOrder_ID());

        boolean isUpdated = preparedStatement.executeUpdate() > 0;
        return isUpdated;
    }

    public static boolean saveOrder(String orderId, String cusId, LocalDate date) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Orders  VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, orderId);
        preparedStatement.setString(2, cusId);
        preparedStatement.setString(3, String.valueOf(date));

        boolean isSaved = preparedStatement.executeUpdate() > 0;
        return isSaved;
    }

    public boolean deleteOrders(String Order_ID) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE  FROM Orders  WHERE Order_ID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, Order_ID);

        boolean isDeleted = preparedStatement.executeUpdate() > 0;
        return isDeleted;

    }

    public OrdersTm searchOrder(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Orders WHERE Order_ID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();

        OrdersTm dto = null;

        if (resultSet.next()) {
            String Order_id = resultSet.getString(1);
            String C_ID = resultSet.getString(2);
            LocalDate date = LocalDate.parse(String.valueOf(resultSet.getDate(3)));

            dto = new OrdersTm(Order_id, C_ID, date);
        }

        return dto;
    }

    public List<OrdersTm> getAllOrders() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Orders";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<OrdersTm> dtoList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();

        while (resultSet.next()) {
            String Order_id = resultSet.getString(1);
            String C_ID = resultSet.getString(2);
            LocalDate date = LocalDate.parse(String.valueOf(resultSet.getDate(3)));
            var Tm = new OrdersTm(Order_id, C_ID, date);
            dtoList.add(Tm);
        }
        return dtoList;
    }


    public String generateNextOrderId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT Order_ID FROM Orders ORDER BY Order_ID DESC LIMIT 1";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        String currentOrderId = null;

        if (resultSet.next()) {
            currentOrderId = resultSet.getString(1);
            return splitOrderId(currentOrderId);
        }
        return splitOrderId(null);
    }

    private String splitOrderId(String currentOrderId) {    //O008
        if (currentOrderId != null) {
            String[] split = currentOrderId.split("O");
            int id = Integer.parseInt(split[1]);    //008
            id++;  //9
            String formattedId=String.format("%03d",id);
            return "O" + formattedId;
        }
        return "O001";
    }

    public List<OrderDto> loadAllOrder_ID() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Orders";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        List<OrderDto> order_IDList = new ArrayList<>();

        while (resultSet.next()) {
            order_IDList.add(new OrderDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDate(3).toLocalDate()
            ));
        }
        return order_IDList;
    }
    public int countDailyOrders() throws SQLException {
        int count=0;
        Connection connection = DbConnection.getInstance().getConnection();
        String sql="SELECT Order_ID,COUNT(*) AS daily_order_count FROM Orders WHERE DATE(date)=CURDATE() GROUP BY Order_ID";
        PreparedStatement pstm=connection.prepareStatement(sql);
        ResultSet resultSet=pstm.executeQuery();
        while (resultSet.next()) {
            count++;
        }
        return count;


    }
    public int labelCustomerByOrdersCount() throws SQLException {
        int count=0;
        Connection connection = DbConnection.getInstance().getConnection();

        String sql="select C_ID,count(*) as C_ID_Count from Orders group by C_ID";
        PreparedStatement pstm=connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
       while (resultSet.next()){
           count=resultSet.getInt("C_ID_Count");

        }

       return  count;
    }


}
