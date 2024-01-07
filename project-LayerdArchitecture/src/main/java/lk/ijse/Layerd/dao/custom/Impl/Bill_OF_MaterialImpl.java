package lk.ijse.Layerd.dao.custom.Impl;

import lk.ijse.Layerd.bo.custom.Impl.ProductBOImpl;
import lk.ijse.Layerd.bo.custom.Impl.RawMaterialsBOImpl;
import lk.ijse.Layerd.bo.custom.ProductBO;
import lk.ijse.Layerd.bo.custom.RawMaterialsBO;
import lk.ijse.Layerd.db.DbConnection;
import lk.ijse.Layerd.dto.RawMaterialDto;
import lk.ijse.Layerd.view.tdm.CartTm;

import java.sql.SQLException;
import java.util.List;

public class Bill_OF_MaterialImpl {
    private  final RawMaterialsBO rawMaterialsBO=new RawMaterialsBOImpl();
    private  final ProductBO productBO=new ProductBOImpl();

   /*private  final RawMaterialModel rawMaterialModel = new RawMaterialModel();
   private  final ProductModel productModel = new ProductModel();*/

        public boolean updateBillOfMaterials(List<CartTm> cartItems, List<RawMaterialDto> rawMaterials) {

            boolean success = false;
            try {
              DbConnection.getInstance().getConnection();
               // success = productModel.updateItem(cartItems);
                success = productBO.updateItem(cartItems);

                if (success) {
                   // success = rawMaterialModel.isStockUpdated(rawMaterials);
                    success = rawMaterialsBO.isStockUpdated(rawMaterials);

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


