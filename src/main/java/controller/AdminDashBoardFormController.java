package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class AdminDashBoardFormController {

    public AnchorPane adminePane;

    public void initialize(){

    }

    public void saveButtonOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) adminePane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/EmployeeAccountCreateForm.fxml"))));
        stage.setTitle("Admin Form");
        stage.show();
    }

    public void homeButtonOnAction(ActionEvent actionEvent) {
        Stage stage=(Stage) adminePane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/DashBoardForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }
}
