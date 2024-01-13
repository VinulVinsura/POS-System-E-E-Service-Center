package bo.Impl;

import bo.EmployeeBo;
import dao.Custm.EmployeeDao;
import dao.Custm.Impl.EmployeeDaoImpl;
import dto.EmployeeDto;
import entity.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public boolean updateEmployee(EmployeeDto dto) {
        return employeeDao.update(new Employee(dto.getEmployeeID(),
                 dto.getEmployeeName(),
                 dto.getPassword(),
                 dto.getEmail(),
                 dto.getPhoneNum()));
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        try {
            List<Employee> list = employeeDao.getAll();
            List<EmployeeDto> dtoList=new ArrayList<>();
            for (Employee employee:list) {
                dtoList.add(new EmployeeDto(employee.getEmployee_ID(),
                        employee.getEmployee_Name(),
                        employee.getPassword(),
                        employee.getEmail(),
                        employee.getPhone_Num()));
            }
            return dtoList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
