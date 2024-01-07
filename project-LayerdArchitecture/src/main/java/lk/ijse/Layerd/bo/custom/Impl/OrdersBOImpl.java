package lk.ijse.Layerd.bo.custom.Impl;

import lk.ijse.Layerd.bo.custom.OrdersBO;
import lk.ijse.Layerd.dao.DAOFactory;
import lk.ijse.Layerd.dao.custom.OrdersDAO;
import lk.ijse.Layerd.dto.OrderDto;
import lk.ijse.Layerd.entity.Orders;
import lk.ijse.Layerd.view.tdm.OrdersTm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersBOImpl implements OrdersBO {
    OrdersDAO ordersDAO= (OrdersDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.getTypes.ORDERS);
    @Override
    public boolean saveOrders(OrdersTm Tm) throws SQLException {
        return ordersDAO.save(new Orders(Tm.getOrder_ID(), Tm.getC_ID(), Tm.getDate()));
    }

    @Override
    public boolean updateOrders(OrdersTm Tm) throws SQLException {
        return ordersDAO.update(new Orders(Tm.getOrder_ID(), Tm.getC_ID(), Tm.getDate()));
    }

    @Override
    public boolean deleteOrders(String Order_ID) throws SQLException {
        return ordersDAO.delete(Order_ID);
    }

    @Override
    public OrdersTm searchOrder(String id) throws SQLException {
        Orders orders= ordersDAO.search(id);
      return  new OrdersTm(orders.getOrder_ID(),orders.getC_ID(),orders.getDate()) ;
    }

    @Override
    public List<OrdersTm> getAllOrders() throws SQLException {
        List<Orders>orders=ordersDAO.getAll();
        List<OrdersTm>ordersTms=new ArrayList<>();
        for (Orders order:orders) {
            ordersTms.add(new OrdersTm(
                    order.getOrder_ID(),
                    order.getC_ID(),
                    order.getDate()));
        }
        return  ordersTms;
    }

    @Override
    public String generateNextOrderId() throws SQLException {
        return ordersDAO.generateNextOrderId();
    }

    @Override
    public List<OrderDto> loadAllOrder_ID() throws SQLException {
        return ordersDAO.loadAllOrder_ID();
    }

    @Override
    public int countDailyOrders() throws SQLException {
        return ordersDAO.countDailyOrders();
    }

    @Override
    public int labelCustomerByOrdersCount() throws SQLException {
        return ordersDAO.labelCustomerByOrdersCount();
    }
}
