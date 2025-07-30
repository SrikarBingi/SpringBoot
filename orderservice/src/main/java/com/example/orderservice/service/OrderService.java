package com.example.orderservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orderservice.dao.OrderRepository;
import com.example.orderservice.exceptions.OrderNotFoundException;
import com.example.orderservice.model.Order;

@Service
public class OrderService {

    @Autowired
    OrderRepository repo;

    public List<Order> getOrders(){
        return (List<Order>) repo.findAll();
    }

    public Order getOrderById(Integer oid){
        return repo.findById(oid).orElseThrow(()->new OrderNotFoundException("Order not found with : "+oid));
    }

    public String placeOrder(Order o){
        repo.save(o);
        return "Order placed successfully";
    }

    public String getStatus(Integer oid){
        Order o = repo.findById(oid).orElseThrow(()->new OrderNotFoundException("Order not found with : "+oid));
        return o.getStatus();
    }

    public List<Order> getOrdersByUid(Integer uid){
        return repo.findByUid(uid);
    }
}
