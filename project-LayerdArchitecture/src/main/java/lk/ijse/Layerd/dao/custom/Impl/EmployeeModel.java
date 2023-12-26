package lk.ijse.Layerd.dao.custom.Impl;


import lk.ijse.Layerd.dao.custom.EmployeeDAO;
import lk.ijse.Layerd.dao.sqlUtil;
import lk.ijse.Layerd.dto.EmployeeDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel implements EmployeeDAO {
    @Override
    public boolean save(final EmployeeDto dto) throws SQLException {
      /*  Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Employee VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, dto.getE_ID());
        preparedStatement.setString(2, dto.getName());
        preparedStatement.setString(3, dto.getTel());
        preparedStatement.setString(4, dto.getJobTitle());

        boolean isSaved = preparedStatement.executeUpdate() > 0;
        return isSaved;*/

        return sqlUtil.execute("INSERT INTO Employee VALUES(?,?,?,?)",dto.getE_ID(),dto.getName(),dto.getTel(),dto.getJobTitle());
    }
    @Override
    public boolean update(final EmployeeDto dto) throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE Employee SET name=?,tel=?,jobTitle=? WHERE E_ID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, dto.getName());
        preparedStatement.setString(2, dto.getTel());
        preparedStatement.setString(3, dto.getJobTitle());
        preparedStatement.setString(4, dto.getE_ID());

        boolean isUpdated = preparedStatement.executeUpdate() > 0;
        return isUpdated;*/

        return sqlUtil.execute("UPDATE Employee SET name=?,tel=?,jobTitle=? WHERE E_ID=?",dto.getName(), dto.getTel(),dto.getJobTitle(),dto.getE_ID());
    }
    @Override
    public boolean delete(String E_ID) throws SQLException {
        /*Connection connection=DbConnection.getInstance().getConnection();

        String sql="DELETE  FROM Employee WHERE E_ID=?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1,E_ID);

        boolean isDeleted=preparedStatement.executeUpdate()>0;
        return  isDeleted;*/

        return sqlUtil.execute("DELETE  FROM Employee WHERE E_ID=?",E_ID);

    }

    @Override
    public EmployeeDto search(String id) throws SQLException {
      /*  Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Employee WHERE E_ID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet=sqlUtil.execute("SELECT * FROM Employee WHERE E_ID = ?",id);

        EmployeeDto dto = null;

        if(resultSet.next()) {
            String e_id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String tel = resultSet.getString(3);
            String jobTitle = resultSet.getString(4);


            dto = new EmployeeDto(e_id,name,jobTitle,tel);
        }

        return dto;
    }

    @Override
    public List<EmployeeDto> getAll() throws SQLException {
        /*Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Employee";
        PreparedStatement pstm = connection.prepareStatement(sql);*/

        List<EmployeeDto> dtoList = new ArrayList<>();

       // ResultSet resultSet = pstm.executeQuery();
        ResultSet resultSet=sqlUtil.execute("SELECT * FROM Employee");

        while (resultSet.next()) {
            String e_id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String tel = resultSet.getString(3);
            String jobTitle = resultSet.getString(4);


            var dto = new EmployeeDto(e_id,name,jobTitle,tel);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<EmployeeDto> loadAllEmployee() throws SQLException {
       /* Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM Employee";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();*/
        ResultSet resultSet=sqlUtil.execute("SELECT * FROM Employee");

        List<EmployeeDto> EmployeeList = new ArrayList<>();

        while (resultSet.next()) {
            EmployeeList.add(new EmployeeDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            ));
        }
        return EmployeeList;
    }

    @Override
    public int countEmployee() throws SQLException {
        int count=0;
      /*  Connection connection = DbConnection.getInstance().getConnection();
        String sql = "select E_ID,count(*) as count from Employee group by E_ID";

        PreparedStatement pstm=connection.prepareStatement(sql);
        ResultSet resultSet=pstm.executeQuery();*/

        ResultSet resultSet=sqlUtil.execute( "SELECT E_ID,COUNT(*) AS count FROM Employee GROUP BY E_ID");
        while (resultSet.next()) {
             count++;
        }
        return count;
    }
}

