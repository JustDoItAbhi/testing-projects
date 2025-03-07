package com.cancelorder.cancelorder.controller;

import com.cancelorder.cancelorder.dto.CancelOrderRequestDto;
import com.cancelorder.cancelorder.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public  class OrderController {

    @Autowired
    private IOrderService orderService;

    //Add your APIs here
    @DeleteMapping("/")
    public ResponseEntity<Boolean> deleteOrder(@RequestBody CancelOrderRequestDto dtos) throws OrderNotFoundException{
        return ResponseEntity.ok(orderService.cancelOrder(dtos.getOrderId()));
    }
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<String> cancelOrderExeption(OrderNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
