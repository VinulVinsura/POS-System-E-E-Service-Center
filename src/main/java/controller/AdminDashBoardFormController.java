package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class AdminDashBoardFormController {
    public AnchorPane pane2;

    public void initialize(){

    }

    public void saveButtonOnAction(ActionEvent actionEvent) throws IOException {
       Stage stage = (Stage)pane2.getScene().getWindow();
       stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/EmployeeAccountCreateForm.fxml"))));
       stage.show();
    }
}
