package com.example.demo.repositories;

import com.example.demo.entities.Items;
import com.example.demo.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ItemsRepository extends JpaRepository<Items,Long> {
}
