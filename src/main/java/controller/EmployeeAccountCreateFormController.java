package controller;

import bo.EmployeeBo;
import bo.Impl.EmployeeBoImpl;
import dto.EmployeeDto;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class EmployeeAccountCreateFormController {
    public TextField texName;
    public TextField texPhone;
    public Label employeeID;
    public TextField texPassword;
    public TextField texEmail2;
    private EmployeeBo employeeBo=new EmployeeBoImpl();
    public void initialize(){
        employeeID.setText(employeeBo.generateEmployeeID());
    }
    public void submitButtonOnAction(ActionEvent actionEvent) {
        boolean isSave=false;
        if (texName!=null || texPassword!=null || texEmail2!=null ||texPhone!=null) {
            isSave= employeeBo.saveEmployee(new EmployeeDto(employeeBo.generateEmployeeID(),
                    texName.getText(),
                    texPassword.getText(),
                    texEmail2.getText(),
                    texPhone.getText()));
        }
        if (isSave){
              new Alert(Alert.AlertType.INFORMATION,"Employee Account Created..").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"ERROR..");
        }
    }
}

