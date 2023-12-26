package lk.ijse.Layerd.dao.custom.Impl;

import lk.ijse.Layerd.dao.custom.CustomerDAO;
import lk.ijse.Layerd.dao.sqlUtil;
import lk.ijse.Layerd.dto.CustomerDto;
import lk.ijse.Layerd.view.tdm.CustomerTm;
import lk.ijse.Layerd.view.tdm.CustomerTmDis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel implements CustomerDAO {
    @Override
    public boolean deleteCustomer(String C_ID) throws SQLException {
        return sqlUtil.execute("DELETE  FROM Customer WHERE C_ID=?",C_ID);
    }

    @Override
    public boolean saveCustomer(CustomerTmDis dto) throws SQLException {
        return sqlUtil.execute("INSERT INTO Customer VALUES(?,?,?,?,?)",dto.getC_ID(),dto.getName(),dto.getAddress(),dto.getLoyaltyStatus(),dto.getTel());
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws SQLException {

        return sqlUtil.execute("UPDATE Customer  SET name=?,address=?,LoyaltyStatus=?,tel=? WHERE C_ID=?",dto.getName(),dto.getAddress(),dto.getLoyaltyStatus(),dto.getTel(),dto.getC_ID());
    }

    @Override
    public CustomerDto searchCustomer(String id) throws SQLException {
        ResultSet resultSet=sqlUtil.execute("SELECT * FROM Customer WHERE C_ID = ?",id);

        CustomerDto dto = null;

        if(resultSet.next()) {
            String cus_id = resultSet.getString(1);
            String cus_name = resultSet.getString(2);
            String cus_address = resultSet.getString(3);
            String cus_tel = resultSet.getString(4);
            String LoyeltyStatus=resultSet.getString(5);

            dto = new CustomerDto(cus_id, cus_name, cus_address, cus_tel,LoyeltyStatus);
        }

        return dto;
    }

    @Override
    public List<CustomerDto> getAllCustomers() throws SQLException {
        List<CustomerDto> dtoList = new ArrayList<>();

        // ResultSet resultSet = pstm.executeQuery();

        ResultSet resultSet=sqlUtil.execute("SELECT * FROM Customer");

        while (resultSet.next()) {
            String cus_id = resultSet.getString(1);
            String cus_name = resultSet.getString(2);
            String cus_address = resultSet.getString(3);
            String cus_tel = resultSet.getString(4);
            String LoyaltyStatus=resultSet.getString(5);

            var dto = new CustomerDto(cus_id, cus_name, cus_address, cus_tel,LoyaltyStatus);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<CustomerTm> loadAllCustomers() throws SQLException {

        ResultSet resultSet=sqlUtil.execute("SELECT * FROM Customer");

        List<CustomerTm> cusList = new ArrayList<>();

        while (resultSet.next()) {
            cusList.add(new CustomerTm(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)


            ));
        }
        return cusList;
    }

}






