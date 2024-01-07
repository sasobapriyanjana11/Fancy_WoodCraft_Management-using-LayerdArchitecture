package lk.ijse.Layerd.bo.custom.Impl;

import lk.ijse.Layerd.bo.BOFactory;
import lk.ijse.Layerd.bo.custom.CustomerBO;
import lk.ijse.Layerd.dao.DAOFactory;
import lk.ijse.Layerd.dao.custom.CustomerDAO;
import lk.ijse.Layerd.dto.CustomerDto;
import lk.ijse.Layerd.entity.Customer;
import lk.ijse.Layerd.view.tdm.CustomerTm;
import lk.ijse.Layerd.view.tdm.CustomerTmDis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO= (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.getTypes.CUSTOMER);

    @Override

    public boolean saveCustomer(CustomerDto dto) throws SQLException {
        return customerDAO.save(new Customer(dto.getC_ID(),dto.getName(),dto.getAddress(),dto.getLoyaltyStatus(),dto.getTel()));
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws SQLException {
        return customerDAO.update(new Customer(dto.getC_ID(),dto.getName(),dto.getAddress(),dto.getLoyaltyStatus(),dto.getTel()));
    }

    @Override
    public boolean deleteCustomer(String C_ID) throws SQLException {
        return customerDAO.delete(C_ID);
    }

    @Override
    public CustomerDto searchCustomer(String id) throws SQLException {
        Customer customer=customerDAO.search(id);
        return new CustomerDto(customer.getC_ID(),customer.getName(),customer.getAddress(),customer.getLoyaltyStatus(), customer.getTel());
    }

    @Override
    public List<CustomerDto> getAllCustomers() throws SQLException {
        List<Customer>customers=customerDAO.getAll();
        List<CustomerDto>customerDtos=new ArrayList<>();
        for (Customer customer:customers) {
            customerDtos.add(new CustomerDto(
                    customer.getC_ID(),
                    customer.getName(),
                    customer.getAddress(),
                    customer.getLoyaltyStatus(),
                    customer.getTel()
                    )
            );
        }
        return customerDtos;
    }

    @Override
    public List<CustomerTm> loadAllCustomers() throws SQLException {
        return customerDAO.loadAllCustomers();
    }
}
