package controller;

import bo.EmployeeBo;
import bo.Impl.EmployeeBoImpl;
import dto.EmployeeDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EmployeeAccountCreateFormController {
    public TextField texName;
    public TextField texPhone;
    public Label employeeID;
    public TextField texPassword;
    public TextField texEmail2;

    public AnchorPane createEmmployePane;
    private EmployeeBo employeeBo=new EmployeeBoImpl();
    public void initialize(){
        employeeID.setText(employeeBo.generateEmployeeID());
    }
    public void submitButtonOnAction(ActionEvent actionEvent) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        String encryptPassword = employeeBo.encrypt(texPassword.getText());

        boolean isSave= employeeBo.saveEmployee(new EmployeeDto(employeeBo.generateEmployeeID(),
                    texName.getText(),
                    encryptPassword,
                    texEmail2.getText(),
                    texPhone.getText()));

        if (isSave){
              new Alert(Alert.AlertType.INFORMATION,"Employee Account Created..").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"ERROR..");
        }
    }


    public void backButtonOnAction(ActionEvent actionEvent) {
        Stage stage= (Stage) createEmmployePane.getScene().getWindow();
        System.out.println("prb1");
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/AdminDashBoardForm.fxml"))));
            System.out.println("prb2");
        } catch (IOException e) {
            System.out.println("prb3");
        }
        stage.setTitle("Admin Form");
        stage.show();
    }
}

