package lk.ijse.Layerd.bo.custom.Impl;

import lk.ijse.Layerd.bo.custom.SupplierBO;
import lk.ijse.Layerd.dao.DAOFactory;
import lk.ijse.Layerd.dao.custom.SupplierDAO;
import lk.ijse.Layerd.dto.SupplierDto;
import lk.ijse.Layerd.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierBOImpl implements SupplierBO {
    SupplierDAO supplierDAO= (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.getTypes.SUPPLIER);
    @Override
    public boolean saveSupplier(SupplierDto dto) throws SQLException {
        return supplierDAO.save(new Supplier(dto.getSupplier_ID(),  dto.getName(), dto.getAddress(),dto.getTel()));
    }

    @Override
    public boolean updateSupplier(SupplierDto dto) throws SQLException {
        return supplierDAO.update(new Supplier(dto.getSupplier_ID(),  dto.getName(), dto.getAddress(),dto.getTel()));
    }

    @Override
    public boolean deleteSupplier(String Supplier_ID) throws SQLException {
        return supplierDAO.delete(Supplier_ID);
    }

    @Override
    public SupplierDto searchSupplier(String id) throws SQLException {
        Supplier supplier=supplierDAO.search(id);
        SupplierDto supplierDto=new SupplierDto(supplier.getSupplier_ID(),supplier.getName(),supplier.getAddress(),supplier.getTel());

        return supplierDto;
    }

    @Override
    public List<SupplierDto> getAllSuppliers() throws SQLException {
        List<Supplier> suppliers=supplierDAO.getAll();
        List<SupplierDto> supplierDtos =new ArrayList<>();
        for (Supplier supplier:suppliers) {
            supplierDtos.add(new SupplierDto(
                    supplier.getSupplier_ID(),
                    supplier.getName(),
                    supplier.getAddress(),
                    supplier.getTel())
            );
        }
        return supplierDtos;
    }
}
