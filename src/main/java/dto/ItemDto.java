package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class ItemDto {
    private String itemCode;
    private String catogry;
    private String description;
    private String productName;
    private String status;
    private String customerID;
    private String orderID;


}
