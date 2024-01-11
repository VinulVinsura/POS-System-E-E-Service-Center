package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeFormController {

    public AnchorPane employeePane;
    public Label labelEmployeeID;
    public void initialize(){

    }

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
