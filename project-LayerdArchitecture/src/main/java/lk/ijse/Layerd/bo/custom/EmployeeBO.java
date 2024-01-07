package lk.ijse.Layerd.bo.custom;

import lk.ijse.Layerd.bo.SuperBO;
import lk.ijse.Layerd.dto.EmployeeDto;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO extends SuperBO {
   boolean saveEmployee(final EmployeeDto dto) throws SQLException ;

     boolean updateEmployee(final EmployeeDto dto) throws SQLException ;

     boolean deleteEmployee(String E_ID) throws SQLException ;

     EmployeeDto searchEmployee(String id) throws SQLException ;

     List<EmployeeDto> getAllEmployee() throws SQLException ;

    List<EmployeeDto> loadAllEmployee() throws SQLException;

    int countEmployee() throws SQLException ;
}
