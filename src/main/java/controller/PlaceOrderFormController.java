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
    private CustomerBo customerBo=new CustomerBoImpl();
    private ItemBo itemBo=new ItemBoImpl();
    private OrderBo orderBo=new OrderBoImpl();
    public void initialize(){
        itemChosBox.getItems().addAll("Electronic","Electrical");
    }

    public void placeButtonOnAction(ActionEvent actionEvent) {
        boolean isCustomerSave = customerBo.saveCustomer(new CustomerDto("C001",
                texCustomerName.getText(),
                texEmail.getText(),
                texNumber.getText()));
        boolean isItemSave = itemBo.saveItem(new ItemDto("E001",
                itemChosBox.getSelectionModel().getSelectedItem(),
                texDesc.getText(),
                texProductName.getText(),
                "Pending"));


    }
}
