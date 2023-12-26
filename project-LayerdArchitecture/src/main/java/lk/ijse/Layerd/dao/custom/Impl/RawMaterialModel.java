package lk.ijse.Layerd.dao.custom.Impl;


import lk.ijse.Layerd.dao.custom.RawMaterialsDAO;
import lk.ijse.Layerd.dao.sqlUtil;
import lk.ijse.Layerd.db.DbConnection;
import lk.ijse.Layerd.dto.RawMaterialDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RawMaterialModel implements RawMaterialsDAO {

   @Override
    public  boolean save(final RawMaterialDto dto) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO RawMaterial  VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, dto.getRawMaterial_ID());
        preparedStatement.setString(2, dto.getMaterialName());
        preparedStatement.setInt(3, Integer.parseInt(String.valueOf(dto.getQty())));
        preparedStatement.setString(4, dto.getSupplier_ID());

        boolean isSaved = preparedStatement.executeUpdate() > 0;
        return isSaved;*/

        return sqlUtil.execute("INSERT INTO RawMaterial  VALUES(?,?,?,?)",dto.getRawMaterial_ID(),dto.getMaterialName(),dto.getQty(),dto.getSupplier_ID());
    }
 @Override
    public boolean update(final RawMaterialDto dto) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE RawMaterial SET MaterialName=?,Supplier_ID=?,QTY=? WHERE RawMaterial_ID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, dto.getMaterialName());
        preparedStatement.setString(2, dto.getSupplier_ID());
        preparedStatement.setInt(3, Integer.parseInt(String.valueOf(dto.getQty())));
        preparedStatement.setString(4, dto.getRawMaterial_ID());


        boolean isUpdated = preparedStatement.executeUpdate() > 0;
        return isUpdated;*/

        return sqlUtil.execute("UPDATE RawMaterial SET MaterialName=?,Supplier_ID=?,QTY=? WHERE RawMaterial_ID=?",dto.getMaterialName(), dto.getSupplier_ID(),dto.getQty(),dto.getRawMaterial_ID());


    }
  @Override
    public boolean delete(String RawMaterial_ID) throws SQLException {
        /*Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE  FROM RawMaterial WHERE RawMaterial_ID =?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, RawMaterial_ID);

        boolean isDeleted = preparedStatement.executeUpdate() > 0;
        return isDeleted;*/

        return sqlUtil.execute("DELETE  FROM RawMaterial WHERE RawMaterial_ID =?",RawMaterial_ID);

    }
@Override
    public List<RawMaterialDto> getAll() throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM RawMaterial";
        PreparedStatement pstm = connection.prepareStatement(sql);*/

        List<RawMaterialDto> dtoList = new ArrayList<>();

        //ResultSet resultSet = pstm.executeQuery();

        ResultSet resultSet=sqlUtil.execute("SELECT * FROM RawMaterial");

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
 @Override
    public RawMaterialDto  search(String id) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM RawMaterial  WHERE RawMaterial_ID= ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet=sqlUtil.execute("SELECT * FROM RawMaterial  WHERE RawMaterial_ID= ?",id);

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
@Override
public boolean isStockUpdated( List<RawMaterialDto> tmList) throws SQLException {
    for (RawMaterialDto dto : tmList) {
        if(!isStockUpdated( dto)) {
            return false;
        }
    }
    return true;
}

    private boolean isStockUpdated(RawMaterialDto dto) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO RawMaterial VALUES(?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getRawMaterial_ID());
        pstm.setString(2, dto.getMaterialName());
        pstm.setInt(3, Integer.parseInt(String.valueOf(dto.getQty())));
        pstm.setString(4, dto.getSupplier_ID());

        return pstm.executeUpdate() > 0;*/

        return  sqlUtil.execute("INSERT INTO RawMaterial VALUES(?, ?, ?, ?)",dto.getRawMaterial_ID(),dto.getMaterialName(),dto.getQty(),dto.getSupplier_ID());
    }


}