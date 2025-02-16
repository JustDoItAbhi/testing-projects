package inventory2.inventory2.inventory.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="product")
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseModel{
    private String name;
    private String description;
    private double price;
}
