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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.List;

public class EmployeeAccountUpdateController {


    public JFXTextField texEmployeeName;
    public JFXTextField texPassword;
    public JFXTextField texEmail;
    public JFXTextField texPhone;

    public Label lableEmployeeID;
    private EmployeeBo employeeBo=new EmployeeBoImpl();

    public void initialize(){
         lodeEmployeeID();
    }

    private void lodeEmployeeID() {
        List<EmployeeDto> employeeList = employeeBo.getAllEmployee();
        ObservableList list= FXCollections.observableArrayList();
        for (EmployeeDto dto:employeeList) {
            list.add(dto.getEmployeeID());
        }


    }

    public void updateButtonOnAction(ActionEvent actionEvent) {

    }
}
