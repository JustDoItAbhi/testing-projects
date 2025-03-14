package com.cancelorder.cancelorder.repo;


import com.cancelorder.cancelorder.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {
    Order save(Order order);
}