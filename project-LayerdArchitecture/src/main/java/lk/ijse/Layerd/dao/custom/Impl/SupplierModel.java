package lk.ijse.Layerd.dao.custom.Impl;

import lk.ijse.FancyWoodCraftManagement.db.DbConnection;
import lk.ijse.FancyWoodCraftManagement.dto.SupplierDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierModel {

    public boolean saveSupplier(final SupplierDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Supplier VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, dto.getSupplier_ID());
        preparedStatement.setString(2, dto.getName());
        preparedStatement.setString(3, dto.getAddress());
        preparedStatement.setString(4, dto.getTel());

        boolean isSaved = preparedStatement.executeUpdate() > 0;
        return isSaved;
    }

    public boolean updateSupplier(final SupplierDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE Supplier SET name=?,address=?,tel=? WHERE Supplier_ID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, dto.getName());
        preparedStatement.setString(2, dto.getAddress());
        preparedStatement.setString(3, dto.getTel());
        preparedStatement.setString(4, dto.getSupplier_ID());

        boolean isUpdated = preparedStatement.executeUpdate() > 0;
        return isUpdated;
    }

    public boolean deleteSupplier(String Supplier_ID) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE  FROM Supplier WHERE Supplier_ID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, Supplier_ID);

        boolean isDeleted = preparedStatement.executeUpdate() > 0;
        return isDeleted;

    }

    public SupplierDto searchSupplier(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Supplier WHERE Supplier_ID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();

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

    public List<SupplierDto> getAllSuppliers() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Supplier";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<SupplierDto> dtoList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();

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

