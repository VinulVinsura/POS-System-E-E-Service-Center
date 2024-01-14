package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class CustomerDto {
    private String customerID;
    private  String customerName;
    private String email;
    private String number;
}
