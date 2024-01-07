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


public class Customer {
    @Id
    private String customerID;
    private String customerName;
    private String email;
    private int phone_Num;
}
