package com.cancelorder.cancelorder.service;

import com.cancelorder.cancelorder.controller.OrderNotFoundException;

public interface IOrderService {
    Boolean cancelOrder(Long orderId) throws OrderNotFoundException;
}
