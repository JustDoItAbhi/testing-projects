package inventory.inventory.repository;

import inventory.inventory.models.Inventory;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRespository extends JpaRepository<Inventory, Integer> {
}
