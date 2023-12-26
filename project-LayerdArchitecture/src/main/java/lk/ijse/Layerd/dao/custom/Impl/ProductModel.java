package lk.ijse.Layerd.dao.custom.Impl;


import lk.ijse.Layerd.dao.custom.ProductDAO;
import lk.ijse.Layerd.dao.sqlUtil;
import lk.ijse.Layerd.db.DbConnection;
import lk.ijse.Layerd.dto.ProductDto;
import lk.ijse.Layerd.view.tdm.CartTm;
import lk.ijse.Layerd.view.tdm.productTm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductModel implements ProductDAO {

   @Override
    public  boolean save(final ProductDto dto) throws SQLException {
       /* Connection connection= DbConnection.getInstance().getConnection();

       String sql="INSERT INTO Product VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1, dto.getProduct_ID());
        preparedStatement.setString(2, dto.getName());
        preparedStatement.setString(3, dto.getDescription());
        preparedStatement.setDouble(4, dto.getPrice());
        preparedStatement.setDouble(5,dto.getQuantityOnStock());
     boolean isSaved=preparedStatement.executeUpdate()>0;

        return  isSaved;*/

        return sqlUtil.execute("INSERT INTO Product VALUES(?,?,?,?,?)",dto.getProduct_ID(),dto.getName(),dto.getDescription(),dto.getPrice(),dto.getQuantityOnStock());

    }
   @Override
    public boolean update(final ProductDto tm) throws SQLException {
        /*Connection connection=DbConnection.getInstance().getConnection();
        String sql="UPDATE Product SET name=?,Description=?,Price=?,Quantity_On_Stock=? WHERE Product_ID=?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);

        preparedStatement.setString(1, tm.getName());
        preparedStatement.setString(2, tm.getDescription());
        preparedStatement.setDouble(3, Double.parseDouble(String.valueOf(tm.getPrice())));
        preparedStatement.setDouble(4,tm.getQuantity_On_Stock());
        preparedStatement.setString(5,tm.getProduct_ID());

        boolean  isUpdated=preparedStatement.executeUpdate()>0;
        return isUpdated;*/

        return sqlUtil.execute("UPDATE Product SET name=?,Description=?,Price=?,Quantity_On_Stock=? WHERE Product_ID=?",tm.getName(),tm.getDescription(),tm.getPrice(),tm.getQuantityOnStock(),tm.getProduct_ID());
    }
    @Override
    public boolean delete(String Product_ID) throws SQLException {
       /* Connection connection=DbConnection.getInstance().getConnection();

        String sql="DELETE  FROM Product WHERE Product_ID=?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1,Product_ID);

        boolean isDeleted=preparedStatement.executeUpdate()>0;
        return  isDeleted;*/

        return sqlUtil.execute("DELETE  FROM Product WHERE Product_ID=?",Product_ID);

    }
    @Override
    public List<ProductDto> loadAllProduct() throws SQLException {
      /*  Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Product";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();*/

        ResultSet resultSet=sqlUtil.execute("SELECT * FROM Product");

        List<ProductDto> proList= new ArrayList<>();

        while (resultSet.next()) {
            proList.add(new ProductDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getInt(5)
            ) );}
        return proList;
    }
@Override
    public List<ProductDto> getAll() throws SQLException {
    /*    Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Product";
        PreparedStatement pstm = connection.prepareStatement(sql);*/

        List<ProductDto> dtoList = new ArrayList<>();

        //ResultSet resultSet = pstm.executeQuery();

        ResultSet resultSet=sqlUtil.execute("SELECT * FROM Product");

        while (resultSet.next()) {
            String Product_ID= resultSet.getString(1);
            String Name= resultSet.getString(2);
            String Description = resultSet.getString(3);
            double Price = resultSet.getDouble(4);
          //  int QTY=resultSet.getInt(5);
            int Quantity_On_Stock=resultSet.getInt(5);

            var dto = new ProductDto(Product_ID,Name,Description,Price,Quantity_On_Stock);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public ProductDto  search(String id) throws SQLException {
      /*  Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Product WHERE Product_ID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet=sqlUtil.execute("SELECT * FROM Product WHERE Product_ID = ?",id);

        ProductDto dto = null;

        if(resultSet.next()) {
            String product_id = resultSet.getString(1);
            String product_name = resultSet.getString(2);
            String desc= resultSet.getString(3);
            Double Price = resultSet.getDouble(4);
        //    Integer QTY=Integer.valueOf(resultSet.getString(6));
            Integer Quantity_On_Stock=Integer.valueOf(resultSet.getString(5));

            dto = new ProductDto(product_id, product_name, desc, Price,Quantity_On_Stock);
        }

        return dto;
    }

    @Override
    public boolean updateItem(List<CartTm> tmList) throws SQLException {
        for (CartTm cartTm : tmList) {
            if(!updateQty(cartTm)) {
                return false;
            }
        }
        return true;
    }


    private boolean updateQty(CartTm cartTm) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE Product SET Quantity_On_Stock = Quantity_On_Stock -? WHERE Product_ID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, cartTm.getQty());
        pstm.setString(2, cartTm.getCode());

        return pstm.executeUpdate() > 0;*/

        return sqlUtil.execute("UPDATE Product SET Quantity_On_Stock = Quantity_On_Stock -? WHERE Product_ID = ?",cartTm.getQty(),cartTm.getCode());
    }

 @Override
    public List<ProductDto> searchProductByName(String name) throws SQLException {
    Connection connection=  DbConnection.getInstance().getConnection();
        List<ProductDto> productList = new ArrayList<>();

        String sql = "SELECT * FROM Product WHERE name LIKE ?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, "%" + name + "%");

            try (ResultSet resultSet = pst.executeQuery()) {
                while (resultSet.next()) {
                    ProductDto productDto = new ProductDto(
                            resultSet.getString("Product_ID"),
                            resultSet.getString("name"),
                            resultSet.getString("Description"),
                            resultSet.getDouble("Price"),
                            resultSet.getInt("Quantity_On_Stock")
                    );
                    productList.add(productDto);
                }
            }
        }

        return productList;
    }


}

