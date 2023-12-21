package lk.ijse.Layerd.dao.custom.Impl;

import lk.ijse.FancyWoodCraftManagement.db.DbConnection;
import lk.ijse.FancyWoodCraftManagement.dto.PlaceOrderDto;

import java.sql.Connection;
import java.sql.SQLException;

public class PlaceOrderModel {
    private final OrdersModel orderModel = new OrdersModel();
    private final ProductModel productModel = new ProductModel();
    private final OrderDetailModel orderDetailModel = new OrderDetailModel();
    private  final CustomerModel customerModel=new CustomerModel();

    public  boolean placeOrder(PlaceOrderDto pDto) throws SQLException {
        boolean result = false;
        Connection connection = null;

        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            boolean isOrderSaved = orderModel.saveOrder(pDto.getOrderId(), pDto.getCusId(), pDto.getDate());

            if (isOrderSaved) {
                boolean isUpdated = productModel.updateItem(pDto.getTmList());
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
