package lk.ijse.Layerd.dao.custom.Impl;

import lk.ijse.Layerd.dao.custom.CustomerDAO;
import lk.ijse.Layerd.dao.sqlUtil;
import lk.ijse.Layerd.entity.Customer;
import lk.ijse.Layerd.view.tdm.CustomerTm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements CustomerDAO {
    @Override
    public boolean delete(String C_ID) throws SQLException {
        return sqlUtil.execute("DELETE  FROM Customer WHERE C_ID=?",C_ID);
    }

    @Override
    public boolean save(Customer entity) throws SQLException {
        return sqlUtil.execute("INSERT INTO Customer VALUES(?,?,?,?,?)",entity.getC_ID(),entity.getName(),entity.getAddress(),entity.getLoyaltyStatus(),entity.getTel());
    }

    @Override
    public boolean update(Customer entity) throws SQLException {

        return sqlUtil.execute("UPDATE Customer  SET name=?,address=?,LoyaltyStatus=?,tel=? WHERE C_ID=?",entity.getName(),entity.getAddress(),entity.getLoyaltyStatus(),entity.getTel(),entity.getC_ID());
    }

    @Override
    public Customer search(String id) throws SQLException {
        ResultSet resultSet=sqlUtil.execute("SELECT * FROM Customer WHERE C_ID = ?",id);

        Customer entity = null;

        if(resultSet.next()) {
            String cus_id = resultSet.getString(1);
            String cus_name = resultSet.getString(2);
            String cus_address = resultSet.getString(3);
            String cus_tel = resultSet.getString(4);
            String LoyeltyStatus=resultSet.getString(5);

            entity = new Customer(cus_id, cus_name, cus_address, cus_tel,LoyeltyStatus);
        }

        return entity;
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        List<Customer> dtoList = new ArrayList<>();

        // ResultSet resultSet = pstm.executeQuery();

        ResultSet resultSet=sqlUtil.execute("SELECT * FROM Customer");

        while (resultSet.next()) {
            String cus_id = resultSet.getString(1);
            String cus_name = resultSet.getString(2);
            String cus_address = resultSet.getString(3);
            String cus_tel = resultSet.getString(4);
            String LoyaltyStatus=resultSet.getString(5);

            var entity= new Customer(cus_id, cus_name, cus_address, cus_tel,LoyaltyStatus);
            dtoList.add(entity);
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






