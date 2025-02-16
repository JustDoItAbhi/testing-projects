package inventory.inventory.repository;

import inventory.inventory.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRespoitory extends JpaRepository<Product,Integer> {
}
