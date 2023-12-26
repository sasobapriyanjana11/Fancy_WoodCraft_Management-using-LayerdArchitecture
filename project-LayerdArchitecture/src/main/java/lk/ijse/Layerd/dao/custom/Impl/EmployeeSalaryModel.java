package lk.ijse.Layerd.dao.custom.Impl;

import lk.ijse.Layerd.dao.custom.EmployeeSalaryDAO;
import lk.ijse.Layerd.dao.sqlUtil;
import lk.ijse.Layerd.db.DbConnection;
import lk.ijse.Layerd.dto.ESalaryDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSalaryModel implements EmployeeSalaryDAO {
@Override
    public boolean save(final ESalaryDto dto) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Salary VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, dto.getSalary_ID());
        preparedStatement.setString(2, dto.getE_ID());
        preparedStatement.setString(3, dto.getTel());
        preparedStatement.setString(4, String.valueOf(dto.getPayment()));
        preparedStatement.setString(5, dto.getDate());

        boolean isSaved = preparedStatement.executeUpdate() > 0;
        return isSaved;*/
        return sqlUtil.execute("INSERT INTO Salary VALUES(?,?,?,?,?)",dto.getSalary_ID(),dto.getE_ID(),dto.getTel(),dto.getPayment(),dto.getDate());
    }
 @Override
    public boolean update(final ESalaryDto dto) throws SQLException {
      /*  Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE Salary SET E_ID=?,tel=?,date=?,Payment=? WHERE Salary_ID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, dto.getE_ID());
        preparedStatement.setString(2, dto.getTel());
        preparedStatement.setString(3, dto.getDate());
        preparedStatement.setString(4, String.valueOf(dto.getPayment()));
        preparedStatement.setString(5, dto.getSalary_ID());

        boolean isUpdated = preparedStatement.executeUpdate() > 0;
        return isUpdated;*/
        return sqlUtil.execute("UPDATE Salary SET E_ID=?,tel=?,date=?,Payment=? WHERE Salary_ID=?",dto.getE_ID(),dto.getTel(),dto.getDate(),dto.getPayment(), dto.getSalary_ID());
    }
@Override
    public boolean delete(String Salary_ID) throws SQLException {
       /* Connection connection=DbConnection.getInstance().getConnection();

        String sql="DELETE  FROM Salary WHERE Salary_ID=?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1,Salary_ID);

        boolean isDeleted=preparedStatement.executeUpdate()>0;
        return  isDeleted;*/
        return sqlUtil.execute("DELETE  FROM Salary WHERE Salary_ID=?",Salary_ID);

    }
 @Override
    public ESalaryDto search(String id) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Salary WHERE Salary_ID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();*/
        ResultSet resultSet=sqlUtil.execute("SELECT * FROM Salary WHERE Salary_ID = ?",id);

        ESalaryDto dto = null;

        if(resultSet.next()) {
            String ES_id = resultSet.getString(1);
            String E_ID = resultSet.getString(2);
            String tel = resultSet.getString(3);
            Double payment = Double.valueOf(resultSet.getString(4));
            String date=resultSet.getString(5);

            dto = new ESalaryDto(ES_id,E_ID,tel,date,payment);
        }

        return dto;
    }
 @Override
    public List<ESalaryDto> getAll() throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Salary";
        PreparedStatement pstm = connection.prepareStatement(sql);*/

        List<ESalaryDto> dtoList = new ArrayList<>();

       // ResultSet resultSet = pstm.executeQuery();
        ResultSet resultSet=sqlUtil.execute("SELECT * FROM Salary");

        while (resultSet.next()) {
            String ES_id = resultSet.getString(1);
            String E_ID = resultSet.getString(2);
            String tel = resultSet.getString(3);
            Double payment = Double.valueOf(resultSet.getString(4));
            String date=resultSet.getString(5);


            var dto = new ESalaryDto(ES_id,E_ID,tel,date,payment);
            dtoList.add(dto);
        }
        return dtoList;
    }
}

