package controller;

import bo.CustomerBo;
import bo.Impl.CustomerBoImpl;
import bo.Impl.ItemBoImpl;
import bo.Impl.OrderBoImpl;
import bo.ItemBo;
import bo.OrderBo;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDto;
import dto.ItemDto;
import dto.OrderDto;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PlaceOrderFormController {

    public AnchorPane placeOrderPane;
    public JFXTextField texProductName;
    public JFXTextField texEmail;
    public JFXTextField texCustomerName;
    public JFXTextField texDesc;
    public ChoiceBox<String> itemChosBox;
    public JFXTextField texNumber;
    private CustomerBo customerBo=new CustomerBoImpl();
    private ItemBo itemBo=new ItemBoImpl();
    private OrderBo orderBo=new OrderBoImpl();
    public void initialize(){
        itemChosBox.getItems().addAll("Electronic","Electrical");
    }

    public void placeButtonOnAction(ActionEvent actionEvent) {
        boolean isCustomerSave = customerBo.saveCustomer(new CustomerDto(customerBo.generateCustomerID(),
                texCustomerName.getText(),
                texEmail.getText(),
                texNumber.getText()));
        boolean isOrderSave = orderBo.saveOrder(new OrderDto("P001",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd")),
                "C001",
                DashBoardFormController.employeeID));
        boolean isItemSave = itemBo.saveItem(new ItemDto("E001",
                itemChosBox.getSelectionModel().getSelectedItem(),
                texDesc.getText(),
                texProductName.getText(),
                "Pending",
                "C001",
                "P001"));
        if (isCustomerSave && isItemSave && isOrderSave){
            new Alert(Alert.AlertType.INFORMATION,"ORDER PLACE SUCCESSFULLY..").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"ERROR..").show();
        }




    }
}
