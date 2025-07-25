package com.example.orderservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.orderservice.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>{

} 
