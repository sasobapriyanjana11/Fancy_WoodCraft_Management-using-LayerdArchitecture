package lk.ijse.Layerd.bo.custom;

import lk.ijse.Layerd.bo.SuperBO;
import lk.ijse.Layerd.dto.CustomerDto;
import lk.ijse.Layerd.view.tdm.CustomerTm;
import lk.ijse.Layerd.view.tdm.CustomerTmDis;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBO  extends SuperBO {
    boolean saveCustomer(CustomerDto dto) throws SQLException;

    boolean updateCustomer(CustomerDto dto) throws SQLException ;

    boolean deleteCustomer(final String C_ID) throws SQLException ;

    CustomerDto searchCustomer(String id) throws SQLException ;

    List<CustomerDto> getAllCustomers() throws SQLException ;

    List<CustomerTm> loadAllCustomers() throws SQLException ;
}
