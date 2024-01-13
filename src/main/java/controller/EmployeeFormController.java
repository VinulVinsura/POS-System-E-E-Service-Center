package controller;

import bo.EmployeeBo;
import bo.Impl.EmployeeBoImpl;
import com.jfoenix.controls.JFXComboBox;
import dto.EmployeeDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class EmployeeFormController {

    public AnchorPane employeePane;
    public JFXComboBox comboEmployeeID;
    public Label labalID;
    public Label lableName;
    private EmployeeBo employeeBo=new EmployeeBoImpl();
    private ObservableList<String> dtoList= FXCollections.observableArrayList();
    static String id=DashBoardFormController.employeeID;
    static String name=DashBoardFormController.employeeName;

    public void initialize(){
        System.out.println(id);
        labalID.setText(id);
        lableName.setText(name);


    }
   /* private void setEmployeeID(){
        List<EmployeeDto> employeeList = employeeBo.getAllEmployee();
        for (EmployeeDto dto:employeeList) {
            dtoList.add(dto.getEmployeeID());
        }
        comboEmployeeID.setItems(dtoList);
 } */

    public void updateButtonOnAction(ActionEvent actionEvent) {
        Stage stage=(Stage)employeePane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/EmployeeAccountUpdate.fxml"))));
            stage.setTitle("Update Form");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
