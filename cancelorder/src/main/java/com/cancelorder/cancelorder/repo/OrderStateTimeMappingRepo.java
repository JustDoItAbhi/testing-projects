package com.cancelorder.cancelorder.repo;

import com.cancelorder.cancelorder.entity.Order;
import com.cancelorder.cancelorder.entity.OrderStateTimeMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderStateTimeMappingRepo extends JpaRepository<OrderStateTimeMapping,Long> {
    List<OrderStateTimeMapping> findByOrder(Order order);

    OrderStateTimeMapping save(OrderStateTimeMapping orderStateTimeMapping);
}
