package lk.ijse.Layerd.bo.custom;

import lk.ijse.Layerd.bo.SuperBO;
import lk.ijse.Layerd.dto.SupplierDto;

import java.sql.SQLException;
import java.util.List;

public interface SupplierBO extends SuperBO {
      boolean saveSupplier(final SupplierDto dto) throws SQLException ;

     boolean updateSupplier(final SupplierDto dto) throws SQLException ;

     boolean deleteSupplier(String Supplier_ID) throws SQLException ;

     SupplierDto searchSupplier(String id) throws SQLException ;

     List<SupplierDto> getAllSuppliers() throws SQLException;
}
