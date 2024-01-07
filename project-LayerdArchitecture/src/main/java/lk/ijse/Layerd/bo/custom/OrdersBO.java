package lk.ijse.Layerd.bo.custom;

import lk.ijse.Layerd.bo.SuperBO;
import lk.ijse.Layerd.dto.OrderDto;
import lk.ijse.Layerd.view.tdm.OrdersTm;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface OrdersBO extends SuperBO {
     boolean saveOrders(final OrdersTm Tm) throws SQLException ;

     boolean updateOrders(OrdersTm Tm) throws SQLException ;

     boolean deleteOrders(String Order_ID) throws SQLException ;

     OrdersTm searchOrder(String id) throws SQLException ;

     List<OrdersTm> getAllOrders() throws SQLException ;

    String generateNextOrderId() throws SQLException;

    List<OrderDto> loadAllOrder_ID() throws SQLException ;

    int countDailyOrders() throws SQLException ;

    int labelCustomerByOrdersCount() throws SQLException ;
}
