package dto.tb;

import com.jfoenix.controls.JFXButton;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class ItemTb {
    private String itemCode;
    private String catogry;
    private String description;
    private String productName;
    private String status;
    private String customerID;
    private String orderID;
    private JFXButton button;
}
