package controller;

import bo.EmployeeBo;
import bo.Impl.EmployeeBoImpl;
import dto.EmployeeDto;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.CollationElementIterator;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class DashBoardFormController {


    public TextField emailTex;
    public TextField passwordTex;
    public Label timeLble;
    public AnchorPane pane1;
    public PasswordField passwordTexHidde;
    public CheckBox chekBox;
    private EmployeeBo employeeBo=new EmployeeBoImpl();
    static String employeeID;
    static String employeeName;
    private volatile boolean stop=false;


    public void initialize(){
        calulatTime();
    }

    private void calulatTime() {
      /*  Thread thread=new Thread(() ->{
            SimpleDateFormat dateFormat=new SimpleDateFormat("hh:mm:ss a");
            while (!stop){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                final String timeNow=dateFormat.format(new Date());
                Platform.runLater(()->{
                    timeLble.setText(timeNow);
                });
            }
        });
        thread.start(); */

        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, actionEvent ->
                timeLble.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a")))), new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        //live Time
    }


    public void adminButtonOnAction(ActionEvent actionEvent) throws IOException {
       if (emailTex.getText().equals("vinu@gmail") && ((passwordTex.getText().equals("*8ma")) || (passwordTexHidde.getText().equals("*8ma")))){
           Stage stage= (Stage) pane1.getScene().getWindow();
           stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/AdminDashBoardForm.fxml"))));
           stage.setTitle("Admin Form");
           stage.show();
       }else {
           new Alert(Alert.AlertType.ERROR,"INVALID EMAIL OR PASSWORD...").show();
       }
    }

    public void emplyeeButtonOnAction(ActionEvent actionEvent) {
        List<EmployeeDto> employeeList = employeeBo.getAllEmployee();
        boolean isFind=false;
        for (EmployeeDto dto:employeeList) {
            if (dto.getEmail().equals(emailTex.getText()) && (dto.getPassword().equals(passwordTexHidde.getText()) || dto.getPassword().equals(passwordTex.getText()))){
                isFind=true;
                employeeID=dto.getEmployeeID();
                employeeName=dto.getEmployeeName();
                Stage stage= (Stage)pane1.getScene().getWindow();
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/EmployeeForm.fxml"))));
                    stage.show();
                } catch (IOException e) {
                    System.out.println("rantime");
                }
            }

        }
        if (!isFind){
            new Alert(Alert.AlertType.ERROR,"INVALID EMAIL OR PASSWORD...").show();
        }
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

    public void forgotPasswordOnAction(ActionEvent actionEvent) {
        String password = employeeBo.forgotPassword(emailTex.getText());
        System.out.println(password);
    }
}
