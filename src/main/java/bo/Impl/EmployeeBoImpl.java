package bo.Impl;

import bo.EmployeeBo;
import dao.Custm.EmployeeDao;
import dao.Custm.Impl.EmployeeDaoImpl;
import dto.EmployeeDto;
import entity.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static javax.crypto.Cipher.ENCRYPT_MODE;

public class EmployeeBoImpl implements EmployeeBo {
    static byte[] IV = { 0x01, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f };
    String stringKey = "65 12 12 12 12 12 12 12 12 12 12 12 12 12 12 12";
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

    @Override
    public String forgotPassword(String email) {
        try {
            List<Employee> employeList = employeeDao.getAll();
            for (Employee employee:employeList) {
                if (employee.getEmail().equals(email)){
                    return employee.getPassword();
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public String encrypt(String input) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException {
             byte[] secretkey= stringToByteArray(stringKey);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(secretkey, "AES");
        cipher.init(Cipher.ENCRYPT_MODE,key,new IvParameterSpec(IV));
        byte[] cipherText = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);

    }

    @Override
    public String decrypt(String cipherText) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] secretkey= stringToByteArray(stringKey);
        System.out.println(secretkey);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(secretkey, "AES");
        cipher.init(Cipher.DECRYPT_MODE,key,new IvParameterSpec(IV));
        byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(plainText);

    }

    private byte[] stringToByteArray(String stringKey) {
        String[] keyFragments = stringKey.split(" ");

        byte[] key = new byte[16];
        for (int i = 0; i < keyFragments.length; i++) {
            key[i] = Byte.parseByte(keyFragments[i]);
        }
        return key;

    }
}
