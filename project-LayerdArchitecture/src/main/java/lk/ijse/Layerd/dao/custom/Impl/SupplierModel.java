package lk.ijse.Layerd.dao.custom.Impl;

import lk.ijse.Layerd.dao.custom.SupplierDAO;
import lk.ijse.Layerd.dao.sqlUtil;
import lk.ijse.Layerd.db.DbConnection;
import lk.ijse.Layerd.dto.SupplierDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierModel implements SupplierDAO {
@Override
    public boolean save(final SupplierDto dto) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Supplier VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, dto.getSupplier_ID());
        preparedStatement.setString(2, dto.getName());
        preparedStatement.setString(3, dto.getAddress());
        preparedStatement.setString(4, dto.getTel());

        boolean isSaved = preparedStatement.executeUpdate() > 0;
        return isSaved;*/

        return sqlUtil.execute("INSERT INTO Supplier VALUES(?,?,?,?)",dto.getSupplier_ID(),dto.getName(),dto.getAddress(),dto.getTel());
    }
@Override
    public boolean update(final SupplierDto dto) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE Supplier SET name=?,address=?,tel=? WHERE Supplier_ID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, dto.getName());
        preparedStatement.setString(2, dto.getAddress());
        preparedStatement.setString(3, dto.getTel());
        preparedStatement.setString(4, dto.getSupplier_ID());

        boolean isUpdated = preparedStatement.executeUpdate() > 0;
        return isUpdated;*/

        return sqlUtil.execute("UPDATE Supplier SET name=?,address=?,tel=? WHERE Supplier_ID=?",dto.getName(),dto.getAddress(),dto.getTel(),dto.getSupplier_ID());
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
    public SupplierDto search(String id) throws SQLException {
      /*  Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Supplier WHERE Supplier_ID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet=sqlUtil.execute("SELECT * FROM Supplier WHERE Supplier_ID = ?",id);

        SupplierDto dto = null;

        if (resultSet.next()) {
            String supplier_id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String tel = resultSet.getString(4);


            dto = new SupplierDto(supplier_id, name, address, tel);
        }

        return dto;
    }
@Override
    public List<SupplierDto> getAll() throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Supplier";
        PreparedStatement pstm = connection.prepareStatement(sql);*/

        List<SupplierDto> dtoList = new ArrayList<>();

      //  ResultSet resultSet = pstm.executeQuery();

        ResultSet resultSet=sqlUtil.execute("SELECT * FROM Supplier");

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String tel = resultSet.getString(4);


            var dto = new SupplierDto(id, name, address, tel);
            dtoList.add(dto);
        }
        return dtoList;
    }


}

