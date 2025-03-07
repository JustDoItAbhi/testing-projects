package com.cancelorder.cancelorder.repo;


import com.cancelorder.cancelorder.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
    Customer save(Customer customer);
}
