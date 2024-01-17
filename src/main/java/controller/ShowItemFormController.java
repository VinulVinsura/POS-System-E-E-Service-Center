package controller;

import bo.Impl.ItemBoImpl;
import bo.ItemBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.ItemDto;
import dto.tb.ItemTb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ShowItemFormController {

    public TableView<ItemTb> ItemTable;
    public TableColumn codeCol;
    public TableColumn catogaryCol;
    public TableColumn descrCol;
    public TableColumn productCol;
    public TableColumn statusCol;
    public TableColumn custIdCol;
    public TableColumn OrderIdCol;

    public TableColumn deleteCol;
    public AnchorPane showItemPane;
    public JFXTextField texCode;
    public JFXTextField texDescription;
    public JFXTextField texProduct;
    public JFXTextField texStatus;
    public JFXTextField texSearch;
    private ObservableList<ItemTb > list= FXCollections.observableArrayList();
    private ItemBo itemBo=new ItemBoImpl();
    public void initialize(){
        codeCol.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        catogaryCol.setCellValueFactory(new PropertyValueFactory<>("catogry"));
        descrCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        productCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        custIdCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        OrderIdCol.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        deleteCol.setCellValueFactory(new PropertyValueFactory<>("button"));
        lodeItemTable();
        FilteredList<ItemTb> filteredList=new FilteredList<>(list,b->true);
        texSearch.textProperty().addListener((observable, oldValue, newValue) ->{
            filteredList.setPredicate(itemTb ->{
                if (newValue.isEmpty()|| newValue.isBlank()|| newValue==null){
                    return true;
                }
                String searchKey=newValue.toLowerCase();
                if (itemTb.getItemCode().toLowerCase().indexOf(searchKey)>-1){
                    return true;
                } else if (itemTb.getProductName().toLowerCase().indexOf(searchKey) > -1) {
                    return true;
                } else if (itemTb.getOrderID().toLowerCase().indexOf(searchKey) > -1) {
                    return true;
                }else {
                    return false;
                }
                    }
            );
        });
        SortedList<ItemTb> sortedList=new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(ItemTable.comparatorProperty());
        ItemTable.setItems(sortedList);
        ItemTable.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            setDateTexFiled(newValue);
        });

    }

    private void setDateTexFiled(ItemTb newValue) {
           texCode.setText(newValue.getItemCode());
           texCode.setEditable(false);
           texDescription.setText(newValue.getDescription());
           texProduct.setText(newValue.getProductName());
           texStatus.setText(newValue.getStatus());

    }


    private void lodeItemTable() {
        List<ItemDto> allItem = itemBo.getAllItem();
        for (ItemDto dto:allItem) {
            JFXButton button=new JFXButton("Delete");
            list.add(new ItemTb(dto.getItemCode(),
                    dto.getCatogry(),
                    dto.getDescription(),
                    dto.getProductName(),
                    dto.getStatus(),
                    dto.getCustomerID(),
                    dto.getOrderID(),
                    button));

        }
        ItemTable.setItems(list);
    }

    public void backButtonOnAction(ActionEvent actionEvent) {
        Stage stage=(Stage) showItemPane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/EmployeeForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }
}
