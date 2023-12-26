package lk.ijse.Layerd.dao.custom.Impl;

import lk.ijse.Layerd.dao.custom.RawMaterialsDAO;
import lk.ijse.Layerd.dao.custom.SupplierDAO;
import lk.ijse.Layerd.db.DbConnection;
import lk.ijse.Layerd.dto.RawMaterialDto;
import lk.ijse.Layerd.dto.SupplierDto;
import java.sql.SQLException;
import java.util.List;

public class SupplierDetailsModel {

     // private  final  RawMaterialModel rawMaterialModel = new RawMaterialModel();
       //private final SupplierModel supplierModel = new SupplierModel();
    SupplierDAO supplierDAO=new SupplierModel();
    RawMaterialsDAO rawMaterialsDAO=new RawMaterialModel();

        public boolean updateSupplierDetails(List<RawMaterialDto> rawMaterials, List<SupplierDto> suppliers) {
            boolean success = false;

            try {

                DbConnection.getInstance().getConnection().setAutoCommit(false);

                success = rawMaterialsDAO.isStockUpdated(rawMaterials);
                if (success) {
                    success = supplierDAO.update((SupplierDto) suppliers);
                }
                if (success) {
                    DbConnection.getInstance().getConnection().commit();
                } else {
                    DbConnection.getInstance().getConnection().rollback();
                }

            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    DbConnection.getInstance().getConnection().rollback();
                } catch (SQLException rollbackException) {
                    rollbackException.printStackTrace();
                }
            } finally {
                try {
                    DbConnection.getInstance().getConnection().setAutoCommit(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return success;
        }

}
