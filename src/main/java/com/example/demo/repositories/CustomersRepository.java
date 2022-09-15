package com.example.demo.repositories;

import com.example.demo.entities.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomersRepository extends JpaRepository<Customers,Long> {
}
