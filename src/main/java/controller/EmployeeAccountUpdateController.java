package controller;

import bo.EmployeeBo;
import bo.Impl.EmployeeBoImpl;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.EmployeeDto;
import entity.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class EmployeeAccountUpdateController {


    public JFXTextField texEmployeeName;
    public JFXTextField texPassword;
    public JFXTextField texEmail;
    public JFXTextField texPhone;

    public Label lableEmployeeID;
    public AnchorPane updatePane;
    private EmployeeBo employeeBo=new EmployeeBoImpl();
    static String id=DashBoardFormController.employeeID;



    public void initialize() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
         lableEmployeeID.setText(id);
        List<EmployeeDto> employeeList = employeeBo.getAllEmployee();
        for (EmployeeDto dto:employeeList) {
            String decryptPassword = employeeBo.decrypt(dto.getPassword());
            if (dto.getEmployeeID().equals(id)) {
                texEmployeeName.setText(dto.getEmployeeName());
                texEmail.setText(dto.getEmail());
                texPassword.setText(decryptPassword);
                texPhone.setText(dto.getPhoneNum());
            }
        }

    }


    public void updateButtonOnAction(ActionEvent actionEvent) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        String encryptPasswod = employeeBo.encrypt(texPassword.getText());
        boolean isUpdate = employeeBo.updateEmployee(new EmployeeDto(id,
                texEmployeeName.getText(),
                encryptPasswod,
                texEmail.getText(),
                texPhone.getText()));
        if (isUpdate){
            new Alert(Alert.AlertType.INFORMATION,"Update Your Account...");
        }else {
            new Alert(Alert.AlertType.ERROR,"ERROR");
        }
        Stage stage=(Stage)updatePane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/EmployeeForm.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void backButtonOnAction(ActionEvent actionEvent) {
        Stage stage=(Stage)updatePane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/EmployeeForm.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
