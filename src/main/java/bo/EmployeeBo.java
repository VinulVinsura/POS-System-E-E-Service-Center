package bo;

import dto.EmployeeDto;

public interface EmployeeBo {
    boolean saveEmployee(EmployeeDto dto);
    String generateEmployeeID();
}
