package com.cancelorder.cancelorder.repo;

import com.cancelorder.cancelorder.entity.Inventory;
import com.cancelorder.cancelorder.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findByItem(Item item);

    Inventory save(Inventory inventory);
}
