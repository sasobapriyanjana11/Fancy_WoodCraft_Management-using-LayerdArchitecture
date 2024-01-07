package lk.ijse.Layerd.bo.custom;

import lk.ijse.Layerd.bo.SuperBO;
import lk.ijse.Layerd.dto.ESalaryDto;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeSalaryBO extends SuperBO {
    boolean saveESalaryDetails(final ESalaryDto dto) throws SQLException ;

    boolean updateESalaryDetails(final ESalaryDto dto) throws SQLException ;

    boolean deleteESalaryDetails(String Salary_ID) throws SQLException ;

    ESalaryDto searchESalaryDetails(String id) throws SQLException ;

    List<ESalaryDto> getAllESalaryDetails() throws SQLException;
}
