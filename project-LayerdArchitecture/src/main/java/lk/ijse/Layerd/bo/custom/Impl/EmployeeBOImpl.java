package lk.ijse.Layerd.bo.custom.Impl;

import lk.ijse.Layerd.bo.custom.EmployeeBO;
import lk.ijse.Layerd.dao.DAOFactory;
import lk.ijse.Layerd.dao.custom.EmployeeDAO;
import lk.ijse.Layerd.dto.EmployeeDto;
import lk.ijse.Layerd.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO= (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.getTypes.EMPLOYEE);
    @Override
    public boolean saveEmployee(EmployeeDto dto) throws SQLException {
        return employeeDAO.save(new Employee(dto.getE_ID(), dto.getName(),dto.getTel(), dto.getJobTitle()));
    }

    @Override
    public boolean updateEmployee(EmployeeDto dto) throws SQLException {
        //entity.getName(), entity.getTel(),entity.getJobTitle(),entity.getE_ID()
        return employeeDAO.update(new Employee(dto.getE_ID(), dto.getName(),dto.getTel(), dto.getJobTitle()));
    }

    @Override
    public boolean deleteEmployee(String E_ID) throws SQLException {
        return employeeDAO.delete(E_ID);
    }

    @Override
    public EmployeeDto searchEmployee(String id) throws SQLException {
        Employee employee=employeeDAO.search(id);
        EmployeeDto employeeDto=new EmployeeDto(employee.getE_ID(), employee.getName(),employee.getTel(), employee.getJobTitle());
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployee() throws SQLException {
        List<Employee> employee=employeeDAO.getAll();
        List<EmployeeDto>employeeDtos=new ArrayList<>();
        for (Employee employees:employee) {
            employeeDtos.add(new EmployeeDto(
                    employees.getE_ID()
                    , employees.getName()
                    ,employees.getTel()
                    , employees.getJobTitle()
            ));
        }
        return employeeDtos;
    }

    @Override
    public List<EmployeeDto> loadAllEmployee() throws SQLException {
        List<Employee>employees=employeeDAO.loadAllEmployee();
        List<EmployeeDto>employeeDtos=new ArrayList<>();
        for (Employee employee:employees) {
            employeeDtos.add(new EmployeeDto(
                    employee.getE_ID(),
                    employee.getName(),
                    employee.getJobTitle(),
                    employee.getTel()
            ));
        }
        return employeeDtos;
    }

    @Override
    public int countEmployee() throws SQLException {
        return employeeDAO.countEmployee();
    }
}
