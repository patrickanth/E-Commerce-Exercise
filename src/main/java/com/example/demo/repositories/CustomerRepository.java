package com.example.demo.repositories;

import com.example.demo.entities.Customers;
import com.example.demo.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customers,Long> {
}
