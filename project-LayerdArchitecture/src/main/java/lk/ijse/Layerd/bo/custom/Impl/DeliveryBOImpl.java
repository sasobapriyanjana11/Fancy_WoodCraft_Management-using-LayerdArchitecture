package lk.ijse.Layerd.bo.custom.Impl;

import lk.ijse.Layerd.bo.custom.DeliveryBO;
import lk.ijse.Layerd.dao.DAOFactory;
import lk.ijse.Layerd.dao.custom.DeliveryDAO;
import lk.ijse.Layerd.dao.custom.EmployeeDAO;
import lk.ijse.Layerd.dao.custom.OrdersDAO;
import lk.ijse.Layerd.dto.DeliveryDto;
import lk.ijse.Layerd.entity.Delivery;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryBOImpl implements DeliveryBO {
    DeliveryDAO deliveryDAO= (DeliveryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.getTypes.DELIVERY);
    OrdersDAO ordersDAO= (OrdersDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.getTypes.ORDERS);

    EmployeeDAO employeeDAO= (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.getTypes.EMPLOYEE);
    @Override
    public boolean saveDeliveryDetails(DeliveryDto dto) throws SQLException {
        return deliveryDAO.save(new Delivery(
                dto.getDelivery_ID(),
                dto.getOrder_ID(),
                dto.getDelivery_Status(),
                dto.getLocation(),
                dto.getE_ID(),
                dto.getTel()
        ));
    }

    @Override
    public boolean updateDeliveryDetails(DeliveryDto dto) throws SQLException {
        return deliveryDAO.update(new Delivery(
                dto.getDelivery_ID(),
                dto.getOrder_ID(),
                dto.getDelivery_Status(),
                dto.getLocation(),
                dto.getE_ID(),
                dto.getTel()
        ));
    }

    @Override
    public boolean deleteDelivery(String Delivery_ID) throws SQLException {
        return deliveryDAO.delete(Delivery_ID);
    }

    @Override
    public DeliveryDto searchDelivery(String id) throws SQLException {
        Delivery deliveries=deliveryDAO.search(id);
        DeliveryDto deliveryDto=new DeliveryDto(
                deliveries.getDelivery_ID(),
                deliveries.getOrder_ID(),
                deliveries.getDelivery_Status(),
                deliveries.getLocation(),
                deliveries.getE_ID(),
                deliveries.getTel()
        );
        return deliveryDto;
    }

    @Override
    public List<DeliveryDto> getAllDelivery() throws SQLException {
        List<Delivery> deliveries=deliveryDAO.getAll();
        List<DeliveryDto>deliveryDtos=new ArrayList<>();
        for (Delivery delivery: deliveries) {
            //delivery_ID,order_ID,delivery_Status,location,E_ID,tel
            deliveryDtos.add(new DeliveryDto(
                    delivery.getDelivery_ID(),
                    delivery.getOrder_ID(),
                    delivery.getDelivery_Status(),
                    delivery.getLocation(),
                    delivery.getE_ID(),
                    delivery.getTel()));
        }
        return deliveryDtos;
    }
}
