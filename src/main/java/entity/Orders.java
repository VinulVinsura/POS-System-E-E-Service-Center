package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Orders {
    @Id
    private String orderId;
    private String date;

    @ManyToOne
    @JoinColumn(name = "customer_ID",nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_ID",nullable = false)
    private Employee employee;

    @OneToMany(mappedBy = "item_Code")
    private List<Item> itemList=new ArrayList<>();


    public Orders(String orderId, String date) {
        this.orderId = orderId;
        this.date = date;
    }


}
