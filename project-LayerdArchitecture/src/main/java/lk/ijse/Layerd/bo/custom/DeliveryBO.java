package lk.ijse.Layerd.bo.custom;

import lk.ijse.Layerd.bo.SuperBO;
import lk.ijse.Layerd.dto.DeliveryDto;

import java.sql.SQLException;
import java.util.List;

public interface DeliveryBO extends SuperBO {
    boolean saveDeliveryDetails (final DeliveryDto dto) throws SQLException ;

    boolean updateDeliveryDetails(final DeliveryDto dto) throws SQLException ;

    boolean deleteDelivery(String Delivery_ID) throws SQLException ;

    DeliveryDto searchDelivery(String id) throws SQLException ;

    List<DeliveryDto> getAllDelivery() throws SQLException;
}
