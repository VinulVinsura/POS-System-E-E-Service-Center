package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.text.CollationElementIterator;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DashBoardFormController {


    public TextField emailTex;
    public TextField passwordTex;
    public Label timeLble;

    public void initialize(){
        calulatTime();
    }

    private void calulatTime() {

        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, actionEvent -> timeLble.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:MM:SS")))), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }


    public void adminButtonOnAction(ActionEvent actionEvent) {

    }

    public void emplyeeButtonOnAction(ActionEvent actionEvent) {

    }
}
