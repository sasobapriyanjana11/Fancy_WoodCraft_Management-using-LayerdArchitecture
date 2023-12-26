package lk.ijse.Layerd.dao.custom;

import lk.ijse.Layerd.dao.CrudDAO;
import lk.ijse.Layerd.dto.EmployeeDto;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO extends CrudDAO<EmployeeDto> {
    /* boolean saveEmployee(final EmployeeDto dto) throws SQLException ;

     boolean updateEmployee(final EmployeeDto dto) throws SQLException ;

     boolean deleteEmployee(String E_ID) throws SQLException ;

     EmployeeDto searchEmployee(String id) throws SQLException ;

     List<EmployeeDto> getAllEmployee() throws SQLException ;*/

     List<EmployeeDto> loadAllEmployee() throws SQLException ;

     int countEmployee() throws SQLException ;

}
