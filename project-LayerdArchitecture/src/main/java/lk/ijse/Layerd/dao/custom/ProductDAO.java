package lk.ijse.Layerd.dao.custom;

import lk.ijse.Layerd.dao.CrudDAO;
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

public interface ProductDAO extends CrudDAO<ProductDto> {
   /*  boolean saveProduct(final ProductDto dto) throws SQLException ;

    boolean updateProduct(final ProductDto tm) throws SQLException;

    boolean deleteProduct(String Product_ID) throws SQLException;

    ProductDto searchProduct(String id) throws SQLException;

    List<ProductDto> getAllProduct() throws SQLException;*/

    List<ProductDto> loadAllProduct() throws SQLException;

    boolean updateItem(List<CartTm> tmList) throws SQLException;


    List<ProductDto> searchProductByName(String name) throws SQLException;

}