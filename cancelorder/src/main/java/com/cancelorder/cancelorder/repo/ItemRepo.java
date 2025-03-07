package com.cancelorder.cancelorder.repo;

import com.cancelorder.cancelorder.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item,Long> {
    Item save(Item item);
}
