package com.devpro.yuubook.services;

import com.devpro.yuubook.models.dto.CartItem;
import com.devpro.yuubook.models.dto.CustomerAddress;
import com.devpro.yuubook.models.dto.OrderFilter;
import com.devpro.yuubook.models.entities.Order;
import com.devpro.yuubook.models.entities.User;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {

	void saveOrder(List<CartItem> cartItems, CustomerAddress customerAddress);

	List<Order> getOrdersByUserLogin(User userLogin);

	Order getOrderById(Integer id);

	void deleteOrderById(Integer id);

	List<Order> getOrdersDeletedByUserLogin(User userLogin);

    List<Order> filter(OrderFilter orderFilter);
}
