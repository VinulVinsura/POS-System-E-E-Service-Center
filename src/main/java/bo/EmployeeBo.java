package bo;

import dto.EmployeeDto;
import entity.Employee;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface EmployeeBo {
    boolean saveEmployee(EmployeeDto dto);
    String generateEmployeeID();
    boolean updateEmployee(EmployeeDto dto);
    List<EmployeeDto> getAllEmployee();
    String forgotPassword(String email);
    String encrypt (String keyWord) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException;
}
