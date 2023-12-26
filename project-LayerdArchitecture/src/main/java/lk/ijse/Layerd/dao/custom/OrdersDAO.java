package lk.ijse.Layerd.dao.custom;

import lk.ijse.Layerd.dao.CrudDAO;
import lk.ijse.Layerd.dao.sqlUtil;
import lk.ijse.Layerd.dto.OrderDto;
import lk.ijse.Layerd.view.tdm.OrdersTm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface OrdersDAO extends CrudDAO<OrdersTm> {
     /*boolean saveOrders(final OrdersTm Tm) throws SQLException ;

     boolean updateOrders(OrdersTm Tm) throws SQLException ;

     boolean deleteOrders(String Order_ID) throws SQLException ;

     OrdersTm searchOrder(String id) throws SQLException ;


     List<OrdersTm> getAllOrders() throws SQLException ;*/

     String generateNextOrderId() throws SQLException ;

     List<OrderDto> loadAllOrder_ID() throws SQLException ;

     int countDailyOrders() throws SQLException ;

     int labelCustomerByOrdersCount() throws SQLException ;

}
