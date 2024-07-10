package com.example.customer_spring_batch.repository;


import com.example.customer_spring_batch.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer,Integer> {
}