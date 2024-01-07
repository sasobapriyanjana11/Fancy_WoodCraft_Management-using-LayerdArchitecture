package lk.ijse.Layerd.dao.custom.Impl;

import lk.ijse.Layerd.dao.CrudDAO;
import lk.ijse.Layerd.dao.SuperDAO;
import lk.ijse.Layerd.dao.custom.SupplierDAO;
import lk.ijse.Layerd.dao.sqlUtil;
import lk.ijse.Layerd.dto.SupplierDto;
import lk.ijse.Layerd.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierModel implements SupplierDAO {
@Override
    public boolean save(final Supplier entity) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Supplier VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, dto.getSupplier_ID());
        preparedStatement.setString(2, dto.getName());
        preparedStatement.setString(3, dto.getAddress());
        preparedStatement.setString(4, dto.getTel());

        boolean isSaved = preparedStatement.executeUpdate() > 0;
        return isSaved;*/

        return sqlUtil.execute("INSERT INTO Supplier VALUES(?,?,?,?)",entity.getSupplier_ID(),entity.getName(),entity.getAddress(),entity.getTel());
    }
@Override
    public boolean update(final Supplier entity) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE Supplier SET name=?,address=?,tel=? WHERE Supplier_ID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, dto.getName());
        preparedStatement.setString(2, dto.getAddress());
        preparedStatement.setString(3, dto.getTel());
        preparedStatement.setString(4, dto.getSupplier_ID());

        boolean isUpdated = preparedStatement.executeUpdate() > 0;
        return isUpdated;*/

        return sqlUtil.execute("UPDATE Supplier SET name=?,address=?,tel=? WHERE Supplier_ID=?",entity.getName(),entity.getAddress(),entity.getTel(),entity.getSupplier_ID());
    }
@Override
    public boolean delete(String Supplier_ID) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE  FROM Supplier WHERE Supplier_ID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, Supplier_ID);

        boolean isDeleted = preparedStatement.executeUpdate() > 0;
        return isDeleted;*/

        return sqlUtil.execute("DELETE  FROM Supplier WHERE Supplier_ID=?",Supplier_ID);

    }
@Override
    public Supplier search(String id) throws SQLException {
      /*  Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Supplier WHERE Supplier_ID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet=sqlUtil.execute("SELECT * FROM Supplier WHERE Supplier_ID = ?",id);

        Supplier entity = null;

        if (resultSet.next()) {
            String supplier_id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String tel = resultSet.getString(4);


            entity = new Supplier(supplier_id, name, address, tel);
        }

        return entity;
    }
@Override
    public List<Supplier> getAll() throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Supplier";
        PreparedStatement pstm = connection.prepareStatement(sql);*/

        List<Supplier> dtoList = new ArrayList<>();

      //  ResultSet resultSet = pstm.executeQuery();

        ResultSet resultSet=sqlUtil.execute("SELECT * FROM Supplier");

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String tel = resultSet.getString(4);


            var entity = new Supplier(id, name, address, tel);
            dtoList.add(entity);
        }
        return dtoList;
    }


}

