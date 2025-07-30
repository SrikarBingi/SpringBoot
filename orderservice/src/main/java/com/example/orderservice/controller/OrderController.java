package com.example.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.orderservice.model.Order;
import com.example.orderservice.service.OrderService;

@Controller
public class OrderController {

    @Autowired
    OrderService service;

    @GetMapping("/greet")
    public ResponseEntity<String> greet(){
        return new ResponseEntity<String>("Hello from order service !!",HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrders(){
        return new ResponseEntity<List<Order>>(service.getOrders(), HttpStatus.OK);
    }

    @GetMapping("/order/{oid}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer oid){
        return new ResponseEntity<Order>(service.getOrderById(oid), HttpStatus.OK);
    }

    @PostMapping("/place")
    public ResponseEntity<String> placeOrder(@RequestBody Order o){
        return new ResponseEntity<String>(service.placeOrder(o), HttpStatus.CREATED);
    }

    @GetMapping("/status/{oid}")
    public ResponseEntity<String> getStatuc(@PathVariable Integer oid){
        return new ResponseEntity<>(service.getStatus(oid), HttpStatus.OK);
    }


    @GetMapping("/orders/{uid}")
    public ResponseEntity<List<Order>> getOrdersByUid(@PathVariable Integer uid){
        return new ResponseEntity<>(service.getOrdersByUid(uid), HttpStatus.OK);
    }
}
