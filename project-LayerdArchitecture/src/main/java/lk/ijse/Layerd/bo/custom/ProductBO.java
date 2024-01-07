package lk.ijse.Layerd.bo.custom;

import lk.ijse.Layerd.bo.SuperBO;
import lk.ijse.Layerd.dto.ProductDto;
import lk.ijse.Layerd.entity.Product;
import lk.ijse.Layerd.view.tdm.CartTm;

import java.sql.SQLException;
import java.util.List;

public interface ProductBO extends SuperBO {
    boolean saveProduct(final ProductDto dto) throws SQLException ;

    boolean updateProduct(final ProductDto tm) throws SQLException;

    boolean deleteProduct(String Product_ID) throws SQLException;

    ProductDto searchProduct(String id) throws SQLException;

    List<ProductDto> getAllProduct() throws SQLException;

    List<ProductDto> loadAllProduct() throws SQLException;

    boolean updateItem(List<CartTm> tmList) throws SQLException;


}
