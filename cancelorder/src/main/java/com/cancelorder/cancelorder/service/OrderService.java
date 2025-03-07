package com.cancelorder.cancelorder.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.cancelorder.cancelorder.controller.OrderNotFoundException;
import com.cancelorder.cancelorder.entity.*;
import com.cancelorder.cancelorder.repo.*;
import com.cancelorder.cancelorder.service.IOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
public class OrderService implements IOrderService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ItemDetailRepo itemDetailRepo;

    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderStateTimeMappingRepo orderStateTimeMappingRepo;
    @Transactional
    public Boolean cancelOrder(Long orderId) throws OrderNotFoundException {
        Order order=orderRepo.findById(orderId).orElseThrow
                (()->new OrderNotFoundException("orderId is wrong"));

        double totalCost=order.getTotalCost();
        double finalCost=.0;

        List<ItemDetail>itemList=itemDetailRepo.findByOrder(order);
        if(itemList.isEmpty()){
            throw new OrderNotFoundException("item detail is empty");
        }
        for(ItemDetail itemDetail:itemList){
            Item items=itemDetail.getItem();
            long quantity= itemDetail.getQuantity();
            itemDetail.setItem(items);
           itemDetail.setQuantity(0l);
            itemDetailRepo.save(itemDetail);
            Optional<Inventory>iOptional=inventoryRepo.findByItem(items);
            if(iOptional.isEmpty()){
                throw new RuntimeException("ITEM NOT FOUND");
            }
                Inventory inventory=iOptional.get();
                inventory = inventoryRepo.findById(inventory.getId()).orElseThrow(
                        () -> new OrderNotFoundException("INVENTORY NOT FOUND BY ID "));

                inventory.setCount(inventory.getCount() + quantity);

                items.setInventory(iOptional.get());
                inventoryRepo.save(iOptional.get());

                //find total cost left
                totalCost -= items.getPrice() * quantity;
                finalCost = totalCost;

            List<ItemDetail> itemss = order.getItems();
            for (int i = itemss.size() - 1; i >= 0; i--) { // Iterate in reverse order
                if (itemss.get(i).getQuantity() == 0) {
                   itemDetailRepo.delete(itemss.get(i));
                    itemss.remove(i); // Safe removal
                }
            }
            order.setTotalCost(finalCost);
            orderRepo.save(order);
        }

        OrderStateTimeMapping mapping=new OrderStateTimeMapping();
            mapping.setDate(new Date());
            mapping.setOrder(order);
            mapping.setOrderState(OrderState.CANCELLED);
        orderStateTimeMappingRepo.save(mapping);

        Customer customer=order.getCustomer();
        customer.setOrderCancellationCount(customer.getOrderCancellationCount()+1);
        customerRepo.save(customer);

        orderRepo.deleteById(orderId);

        return true;
    }
}
