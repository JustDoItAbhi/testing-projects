package com.cancelorder.cancelorder.repo;

import com.cancelorder.cancelorder.entity.ItemDetail;
import com.cancelorder.cancelorder.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDetailRepo extends JpaRepository<ItemDetail,Long> {
    ItemDetail save(ItemDetail itemDetail);
    List<ItemDetail> findByOrder(Order order);
}
