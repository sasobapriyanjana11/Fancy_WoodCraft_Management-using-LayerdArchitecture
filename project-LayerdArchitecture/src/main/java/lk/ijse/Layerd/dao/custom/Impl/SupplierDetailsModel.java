package lk.ijse.Layerd.dao.custom.Impl;

import lk.ijse.FancyWoodCraftManagement.db.DbConnection;
import lk.ijse.FancyWoodCraftManagement.dto.RawMaterialDto;
import lk.ijse.FancyWoodCraftManagement.dto.SupplierDto;

import java.sql.SQLException;
import java.util.List;

public class SupplierDetailsModel {

      private  final  RawMaterialModel rawMaterialModel = new RawMaterialModel();
       private final SupplierModel supplierModel = new SupplierModel();

        public boolean updateSupplierDetails(List<RawMaterialDto> rawMaterials, List<SupplierDto> suppliers) {
            boolean success = false;

            try {

                DbConnection.getInstance().getConnection().setAutoCommit(false);

                success = rawMaterialModel.isStockUpdated(rawMaterials);
                if (success) {
                    success = supplierModel.updateSupplier((SupplierDto) suppliers);
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
