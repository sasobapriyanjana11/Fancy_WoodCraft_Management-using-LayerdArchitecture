package lk.ijse.Layerd.bo.custom.Impl;

import lk.ijse.Layerd.bo.custom.EmployeeSalaryBO;
import lk.ijse.Layerd.dao.DAOFactory;
import lk.ijse.Layerd.dao.custom.EmployeeSalaryDAO;
import lk.ijse.Layerd.dto.ESalaryDto;
import lk.ijse.Layerd.entity.ESalary;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSalaryBOImpl implements EmployeeSalaryBO {
    EmployeeSalaryDAO employeeSalaryDAO= (EmployeeSalaryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.getTypes.EMPLOYEESALARY);

    @Override
    public boolean saveESalaryDetails(ESalaryDto dto) throws SQLException {
        return employeeSalaryDAO.save(new ESalary(dto.getSalary_ID(),dto.getE_ID(),dto.getTel(), dto.getDate(), dto.getPayment()));
    }

    @Override
    public boolean updateESalaryDetails(ESalaryDto dto) throws SQLException {
        return employeeSalaryDAO.update(new ESalary(dto.getSalary_ID(),dto.getE_ID(),dto.getTel(), dto.getDate(), dto.getPayment()));
    }

    @Override
    public boolean deleteESalaryDetails(String Salary_ID) throws SQLException {
        return employeeSalaryDAO.delete(Salary_ID);
    }

    @Override
    public ESalaryDto searchESalaryDetails(String id) throws SQLException {
        ESalary eSalary=employeeSalaryDAO.search(id);
        ESalaryDto eSalaryDto=new ESalaryDto(
                eSalary.getSalary_ID(),
                eSalary.getE_ID(),
                eSalary.getTel(),
                eSalary.getDate(),
                eSalary.getPayment()
        );
        return eSalaryDto;
    }

    @Override
    public List<ESalaryDto> getAllESalaryDetails() throws SQLException {
        List<ESalary>eSalaries=employeeSalaryDAO.getAll();
        List<ESalaryDto>eSalaryDtos=new ArrayList<>();
        for (ESalary esalary:eSalaries) {
            //ES_id,E_ID,tel,date,payment
           eSalaryDtos.add(new ESalaryDto(
                   esalary.getSalary_ID(),
                   esalary.getE_ID(),
                   esalary.getTel(),
                   esalary.getDate(),
                   esalary.getPayment()
                   ));
        }
        return eSalaryDtos;
    }
}
