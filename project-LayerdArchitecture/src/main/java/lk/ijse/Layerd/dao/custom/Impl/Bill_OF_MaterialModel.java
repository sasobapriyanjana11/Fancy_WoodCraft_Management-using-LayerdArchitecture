package lk.ijse.Layerd.dao.custom.Impl;

import lk.ijse.FancyWoodCraftManagement.db.DbConnection;
import lk.ijse.FancyWoodCraftManagement.dto.RawMaterialDto;
import lk.ijse.FancyWoodCraftManagement.dto.tm.CartTm;

import java.sql.SQLException;
import java.util.List;

public class Bill_OF_MaterialModel {
    private  final RawMaterialModel rawMaterialModel = new RawMaterialModel();
    private  final ProductModel productModel = new ProductModel();
        public boolean updateBillOfMaterials(List<CartTm> cartItems, List<RawMaterialDto> rawMaterials) {

            boolean success = false;
            try {
              DbConnection.getInstance().getConnection();
                success = productModel.updateItem(cartItems);

                if (success) {
                    success = rawMaterialModel.isStockUpdated(rawMaterials);

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


