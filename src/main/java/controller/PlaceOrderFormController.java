package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

public class PlaceOrderFormController {

    public AnchorPane placeOrderPane;
    public JFXTextField texProductName;
    public JFXTextField texEmail;
    public JFXTextField texCustomerName;
    public JFXTextField texDesc;
    public ChoiceBox<String> itemChosBox;
    public JFXTextField texNumber;
    public void initialize(){
        itemChosBox.getItems().addAll("Electronic","Electrical");
    }

    public void placeButtonOnAction(ActionEvent actionEvent) {

    }
}
