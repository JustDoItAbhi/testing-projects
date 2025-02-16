package inventory.inventory.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "inventorys")
public class Inventory extends Basemodel{
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;
    private int quantity;
}
