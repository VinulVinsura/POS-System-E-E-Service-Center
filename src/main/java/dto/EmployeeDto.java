package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class EmployeeDto {
    private String employeeID;
    private String employeeName;
    private String password;
    private String email;
    private String phoneNum;
}
