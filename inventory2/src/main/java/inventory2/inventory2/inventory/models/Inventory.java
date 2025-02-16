package inventory2.inventory2.inventory.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
// @Table(name="inventory")
@EqualsAndHashCode(callSuper = true)
public class Inventory extends BaseModel{
    @ManyToOne
    private Product product;
    private int quantity;
}
