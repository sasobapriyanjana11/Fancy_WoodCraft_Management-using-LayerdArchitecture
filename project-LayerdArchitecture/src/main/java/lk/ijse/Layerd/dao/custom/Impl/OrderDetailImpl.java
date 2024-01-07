package lk.ijse.Layerd.dao.custom.Impl;


import lk.ijse.Layerd.dao.sqlUtil;
import lk.ijse.Layerd.view.tdm.CartTm;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailImpl {
    public boolean saveOrderDetail(String orderId, List<CartTm> tmList) throws SQLException {
        for (CartTm cartTm : tmList) {
            if(!saveOrderDetail(orderId, cartTm)) {
                return false;
            }
        }
        return true;
    }

    private boolean saveOrderDetail(String orderId, CartTm cartTm) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Order_Detail VALUES(?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, orderId);
        pstm.setString(2, cartTm.getCode());
        pstm.setInt(3, cartTm.getQty());
        pstm.setDouble(4, cartTm.getUnitPrice());

        return pstm.executeUpdate() > 0;*/

        return sqlUtil.execute("INSERT INTO Order_Detail VALUES(?, ?, ?, ?)",orderId,cartTm.getCode(),cartTm.getQty(),cartTm.getUnitPrice());
    }

}
