package q54.rublication.aruthor.relations.q54publicationaruthorrelationssingletable.aggregators.products.product;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Subscribe   {
    private int id;
     private List<Products>productsList;

    public Subscribe(List<Products> productsList) {
        this.productsList = productsList;
    }

    public long calculateTotalPrice() {
        long total = 0;
        for (Products product : productsList) {
            total += product.getPrice();
        }
        return total;
    }

}
