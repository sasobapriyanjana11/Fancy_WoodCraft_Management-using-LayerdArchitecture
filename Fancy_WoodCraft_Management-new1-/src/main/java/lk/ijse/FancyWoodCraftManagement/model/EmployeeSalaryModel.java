package lk.ijse.FancyWoodCraftManagement.model;

import lk.ijse.FancyWoodCraftManagement.db.DbConnection;
import lk.ijse.FancyWoodCraftManagement.dto.CustomerDto;
import lk.ijse.FancyWoodCraftManagement.dto.ESalaryDto;
import lk.ijse.FancyWoodCraftManagement.dto.EmployeeDto;
import lk.ijse.FancyWoodCraftManagement.dto.tm.ESalaryTm;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSalaryModel {

    public boolean saveESalaryDetails(final ESalaryDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Salary VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, dto.getSalary_ID());
        preparedStatement.setString(2, dto.getE_ID());
        preparedStatement.setString(3, dto.getTel());
        preparedStatement.setString(4, String.valueOf(dto.getPayment()));
        preparedStatement.setString(5, dto.getDate());

        boolean isSaved = preparedStatement.executeUpdate() > 0;
        return isSaved;
    }

    public boolean updateESalaryDetails(final ESalaryDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE Salary SET E_ID=?,tel=?,date=?,Payment=? WHERE Salary_ID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, dto.getE_ID());
        preparedStatement.setString(2, dto.getTel());
        preparedStatement.setString(3, dto.getDate());
        preparedStatement.setString(4, String.valueOf(dto.getPayment()));
        preparedStatement.setString(5, dto.getSalary_ID());

        boolean isUpdated = preparedStatement.executeUpdate() > 0;
        return isUpdated;
    }
    public boolean deleteESalaryDetails(String Salary_ID) throws SQLException {
        Connection connection=DbConnection.getInstance().getConnection();

        String sql="DELETE  FROM Salary WHERE Salary_ID=?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1,Salary_ID);

        boolean isDeleted=preparedStatement.executeUpdate()>0;
        return  isDeleted;

    }

    public ESalaryDto searchESalaryDetails(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Salary WHERE Salary_ID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();

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

    public List<ESalaryDto> getAllESalaryDetails() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Salary";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<ESalaryDto> dtoList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();

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

