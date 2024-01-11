package bo;

import dto.EmployeeDto;
import entity.Employee;

import java.util.List;

public interface EmployeeBo {
    boolean saveEmployee(EmployeeDto dto);
    String generateEmployeeID();
    boolean updateEmployee(String employeID);
    List<EmployeeDto> getAllEmployee();

}
