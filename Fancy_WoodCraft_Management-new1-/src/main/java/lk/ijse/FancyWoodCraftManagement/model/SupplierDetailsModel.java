package lk.ijse.FancyWoodCraftManagement.model;

import lk.ijse.FancyWoodCraftManagement.db.DbConnection;
import lk.ijse.FancyWoodCraftManagement.dto.PlaceOrderDto;
import lk.ijse.FancyWoodCraftManagement.dto.RawMaterialDto;
import lk.ijse.FancyWoodCraftManagement.dto.SupplierDetailsDto;
import lk.ijse.FancyWoodCraftManagement.dto.SupplierDto;
import lk.ijse.FancyWoodCraftManagement.dto.tm.CartTm;
import lk.ijse.FancyWoodCraftManagement.dto.tm.OrdersTm;
import lk.ijse.FancyWoodCraftManagement.dto.tm.SupplierDetailsTm;
import lk.ijse.FancyWoodCraftManagement.dto.tm.rawmaterialTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
