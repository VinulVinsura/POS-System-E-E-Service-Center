package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity

public class Employee {
    @Id
    private String employee_ID;
    private String employee_Name;
    private String password;
    private String email;
    private int phone_Num;

}
