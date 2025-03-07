package q54.rublication.aruthor.relations.q54publicationaruthorrelationssingletable.aggregators.products.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
private  String name;
private long price;

    public Products(String name, long price) {
        this.name = name;
        this.price = price;
    }
    public long getTotalPrice(){
        return price;
    }

}
