import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class AppInitializer extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("View/DashboardForm.fxml"))));
        primaryStage.centerOnScreen(); //Dashboard center screen
        primaryStage.setResizable(false); //Dashboard can't maximize
        primaryStage.setTitle("E & E Service Center (PVT)Ltd.");
        Image image=new Image("\\img\\logo.png"); //set Title Icon
        primaryStage.getIcons().add(image);

        primaryStage.show();
    }
}
