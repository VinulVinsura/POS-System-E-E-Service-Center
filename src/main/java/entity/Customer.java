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


public class Customer {
    @Id
    private String customer_ID;
    private String customer_Name;
    private String email;
    private int phone_Num;

    @OneToMany(mappedBy = "customer")
    private List<Orders> ordersList=new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<Item> itemList=new ArrayList<>();
    public Customer(String customerID, String customerName, String email, int phone_Num) {
        this.customer_ID = customerID;
        this.customer_Name = customerName;
        this.email = email;
        this.phone_Num = phone_Num;
    }


}
