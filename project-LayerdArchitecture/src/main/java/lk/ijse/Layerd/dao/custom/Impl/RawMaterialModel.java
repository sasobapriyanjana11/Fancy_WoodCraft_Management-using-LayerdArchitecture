package lk.ijse.Layerd.dao.custom.Impl;

import lk.ijse.FancyWoodCraftManagement.db.DbConnection;
import lk.ijse.FancyWoodCraftManagement.dto.RawMaterialDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RawMaterialModel {
    public static boolean saveRawMaterials(final RawMaterialDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO RawMaterial  VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, dto.getRawMaterial_ID());
        preparedStatement.setString(2, dto.getMaterialName());
        preparedStatement.setInt(3, Integer.parseInt(String.valueOf(dto.getQty())));
        preparedStatement.setString(4, dto.getSupplier_ID());

        boolean isSaved = preparedStatement.executeUpdate() > 0;
        return isSaved;
    }

    public boolean updateMaterials(final RawMaterialDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE RawMaterial SET MaterialName=?,Supplier_ID=?,QTY=? WHERE RawMaterial_ID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, dto.getMaterialName());
        preparedStatement.setString(2, dto.getSupplier_ID());
        preparedStatement.setInt(3, Integer.parseInt(String.valueOf(dto.getQty())));
        preparedStatement.setString(4, dto.getRawMaterial_ID());


        boolean isUpdated = preparedStatement.executeUpdate() > 0;
        return isUpdated;


    }

    public boolean deleteMaterial(String RawMaterial_ID) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE  FROM RawMaterial WHERE RawMaterial_ID =?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, RawMaterial_ID);

        boolean isDeleted = preparedStatement.executeUpdate() > 0;
        return isDeleted;

    }

    public List<RawMaterialDto> getAllMaterials() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM RawMaterial";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<RawMaterialDto> dtoList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();

        while (resultSet.next()) {
            String RawMaterial_ID= resultSet.getString(1);
            String MaterialName= resultSet.getString(2);
            Integer Qty = Integer.parseInt(resultSet.getString(3));
            String Supplier_ID=resultSet.getString(4);

            var dto = new RawMaterialDto(RawMaterial_ID,MaterialName,Qty,Supplier_ID);
            dtoList.add(dto);
        }
        return dtoList;
    }
    public RawMaterialDto  searchMaterial(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM RawMaterial  WHERE RawMaterial_ID= ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();

        RawMaterialDto dto = null;

        if(resultSet.next()) {
            String RawMaterial_ID= resultSet.getString(1);
            String MaterialName= resultSet.getString(2);
            Integer Qty = Integer.parseInt(resultSet.getString(3));
            String Supplier_ID=resultSet.getString(4);


            dto = new RawMaterialDto(RawMaterial_ID,MaterialName,Qty,Supplier_ID);
        }

        return dto;
    }

public boolean isStockUpdated( List<RawMaterialDto> tmList) throws SQLException {
    for (RawMaterialDto dto : tmList) {
        if(!isStockUpdated( dto)) {
            return false;
        }
    }
    return true;
}

    private boolean isStockUpdated(RawMaterialDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO RawMaterial VALUES(?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getRawMaterial_ID());
        pstm.setString(2, dto.getMaterialName());
        pstm.setInt(3, Integer.parseInt(String.valueOf(dto.getQty())));
        pstm.setString(4, dto.getSupplier_ID());

        return pstm.executeUpdate() > 0;
    }


}