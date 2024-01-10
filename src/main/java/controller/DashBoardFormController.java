package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.CollationElementIterator;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DashBoardFormController {


    public TextField emailTex;
    public TextField passwordTex;
    public Label timeLble;
    public AnchorPane pane1;
    public PasswordField passwordTexHidde;
    public CheckBox chekBox;

    public void initialize(){
        calulatTime();
    }

    private void calulatTime() {

        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, actionEvent -> timeLble.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:MM:SS")))), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        //live Time
    }


    public void adminButtonOnAction(ActionEvent actionEvent) throws IOException {
       if (emailTex.getText().equals("vinu@gmail") && (passwordTex.getText().equals("*8ma"))|| (passwordTexHidde.getText().equals("*8ma"))){
           Stage stage= (Stage) pane1.getScene().getWindow();
           stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/AdminDashBoardForm.fxml"))));
           stage.setTitle("Admin Form");
           stage.show();
       }else {
           System.out.println("vinul");
       }
    }

    public void emplyeeButtonOnAction(ActionEvent actionEvent) {

    }

    public String chekBokOnAction(ActionEvent actionEvent) {
        if (chekBox.isSelected()){
            passwordTex.setText(passwordTexHidde.getText());
            passwordTex.setVisible(true);
            passwordTexHidde.setVisible(false);
            return passwordTex.getText();
        }
        passwordTexHidde.setText(passwordTex.getText());
        passwordTexHidde.setVisible(true);
        passwordTex.setVisible(false);
        return passwordTexHidde.getText();
    }

    public void chekBokOnAction2(MouseDragEvent mouseDragEvent) {

    }
}
