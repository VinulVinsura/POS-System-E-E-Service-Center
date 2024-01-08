package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "employee")
    private List<Orders>ordersList=new ArrayList<>();

    public Employee(String employee_ID, String employee_Name, String password, String email, int phone_Num) {
        this.employee_ID = employee_ID;
        this.employee_Name = employee_Name;
        this.password = password;
        this.email = email;
        this.phone_Num = phone_Num;
    }
}
