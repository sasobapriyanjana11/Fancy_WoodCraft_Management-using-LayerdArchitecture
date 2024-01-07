package lk.ijse.Layerd.dao.custom.Impl;

import lk.ijse.Layerd.bo.custom.Impl.ProductBOImpl;
import lk.ijse.Layerd.bo.custom.ProductBO;
import lk.ijse.Layerd.db.DbConnection;
import lk.ijse.Layerd.dto.PlaceOrderDto;
import java.sql.Connection;
import java.sql.SQLException;

public class PlaceOrderImpl {
   private final OrdersImpl orderModel = new OrdersImpl();
  //  private final ProductModel productModel = new ProductModel();
    private final OrderDetailImpl orderDetailModel = new OrderDetailImpl();
  //  private  final CustomerModel customerModel=new CustomerModel();

    ProductBO productBO=new ProductBOImpl();


    public  boolean placeOrder(PlaceOrderDto pDto) throws SQLException {
        boolean result = false;
        Connection connection = null;

        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            boolean isOrderSaved = orderModel.saveOrder(pDto.getOrderId(), pDto.getCusId(), pDto.getDate());
            //boolean isOrderSaved = ordersDAO.sa(pDto.getOrderId(),pDto.getCusId(),pDto.getDate());

            if (isOrderSaved) {
                //boolean isUpdated = productModel.updateItem(pDto.getTmList());
                boolean isUpdated = productBO.updateItem(pDto.getTmList());

                if(isUpdated) {
                    boolean isOrderDetailSaved = orderDetailModel.saveOrderDetail(pDto.getOrderId(), pDto.getTmList());
                    if(isOrderDetailSaved) {

                            connection.commit();
                            result = true;

                    }
                }
            }
        } catch (SQLException e) {
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }
        return result;
    }



}
