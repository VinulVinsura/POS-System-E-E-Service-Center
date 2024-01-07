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

public class Item {
    @Id
    private String item_Code;
    private String description;
    private String catogary;
    private String product_Name;
    private String status;
}
