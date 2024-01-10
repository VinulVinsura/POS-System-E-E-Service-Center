package bo.Impl;

import bo.EmployeeBo;
import dao.Custm.EmployeeDao;
import dao.Custm.Impl.EmployeeDaoImpl;
import dto.EmployeeDto;
import entity.Employee;

public class EmployeeBoImpl implements EmployeeBo {
    private EmployeeDao employeeDao=new EmployeeDaoImpl();

    @Override
    public boolean saveEmployee(EmployeeDto dto) {
        return employeeDao.save(new Employee(dto.getEmployeeID(),
                dto.getEmployeeName(),
                dto.getPassword(),
                dto.getEmail(),
                dto.getPhoneNum()));
    }

    @Override
    public String generateEmployeeID() {
        if (employeeDao.getLastEmployee()!=null){
            String employeeId = employeeDao.getLastEmployee().getEmployee_ID();
            int num= Integer.parseInt(employeeId.split("E")[1]);
            num++;
            return String.format("E%03d",num);

        }else {
            return "E001";
        }

    }
}
