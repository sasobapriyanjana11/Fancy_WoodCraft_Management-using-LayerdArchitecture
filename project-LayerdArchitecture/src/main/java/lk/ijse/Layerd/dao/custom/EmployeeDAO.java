package lk.ijse.Layerd.dao.custom;

import lk.ijse.Layerd.dao.CrudDAO;
import lk.ijse.Layerd.dto.EmployeeDto;
import lk.ijse.Layerd.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO extends CrudDAO<Employee> {
    /* boolean saveEmployee(final EmployeeDto dto) throws SQLException ;

     boolean updateEmployee(final EmployeeDto dto) throws SQLException ;

     boolean deleteEmployee(String E_ID) throws SQLException ;

     EmployeeDto searchEmployee(String id) throws SQLException ;

     List<EmployeeDto> getAllEmployee() throws SQLException ;*/

     List<Employee> loadAllEmployee() throws SQLException ;

     int countEmployee() throws SQLException ;

}
