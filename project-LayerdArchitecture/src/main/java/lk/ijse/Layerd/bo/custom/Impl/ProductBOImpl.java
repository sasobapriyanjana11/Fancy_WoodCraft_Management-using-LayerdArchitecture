package lk.ijse.Layerd.bo.custom.Impl;

import lk.ijse.Layerd.bo.custom.ProductBO;
import lk.ijse.Layerd.dao.DAOFactory;
import lk.ijse.Layerd.dao.custom.ProductDAO;
import lk.ijse.Layerd.dto.ProductDto;
import lk.ijse.Layerd.entity.Product;
import lk.ijse.Layerd.view.tdm.CartTm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductBOImpl implements ProductBO {
    ProductDAO productDAO= (ProductDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.getTypes.PRODUCT);

    @Override
    public boolean saveProduct(ProductDto dto) throws SQLException {
        return productDAO.save(new Product(dto.getProduct_ID(),dto.getName(),dto.getDescription(),dto.getPrice(),dto.getQuantityOnStock()));
    }

    @Override
    public boolean updateProduct(ProductDto dto) throws SQLException {
        return productDAO.update(new Product(dto.getProduct_ID(),dto.getName(),dto.getDescription(),dto.getPrice(),dto.getQuantityOnStock()));
    }

    @Override
    public boolean deleteProduct(String Product_ID) throws SQLException {
        return productDAO.delete(Product_ID);
    }

    @Override
    public ProductDto searchProduct(String id) throws SQLException {
        Product dto=productDAO.search(id);
        ProductDto productDto=new ProductDto(dto.getProduct_ID(),dto.getName(),dto.getDescription(),dto.getPrice(),dto.getQuantityOnStock());
        return productDto;
    }

    @Override
    public List<ProductDto> getAllProduct() throws SQLException {
        List<Product>products=productDAO.loadAllProduct();
        List<ProductDto>productDtos=new ArrayList<>();
        for (Product product:products) {
            productDtos.add(new ProductDto(product.getProduct_ID(),
                    product.getName(),
                    product.getDescription(),
                    product.getPrice(),
                    product.getQuantityOnStock()
            ));
        }
        return productDtos;
    }

    @Override
    public List<ProductDto> loadAllProduct() throws SQLException {
        List<Product>products=productDAO.loadAllProduct();
        List<ProductDto>productDtos=new ArrayList<>();
        for (Product product:products) {
            productDtos.add(new ProductDto(
                    product.getProduct_ID(),
                    product.getName(),
                    product.getDescription(),
                    product.getPrice(),
                    product.getQuantityOnStock()
            ));
        }
        return productDtos;
    }

    @Override
    public boolean updateItem(List<CartTm> tmList) throws SQLException {
        return productDAO.updateItem(tmList);
    }

}
