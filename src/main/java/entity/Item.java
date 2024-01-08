package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity

public class Item {
    @Id
    private String item_Code;
    private String description;
    private String catogary;
    private String product_Name;
    private String status;

    @ManyToOne
    @JoinColumn(name = "orderId",nullable = false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "customer_ID",nullable = false)
    private Customer customer;

    public Item(String item_Code, String description, String catogary, String product_Name, String status) {
        this.item_Code = item_Code;
        this.description = description;
        this.catogary = catogary;
        this.product_Name = product_Name;
        this.status = status;
    }


}
