package com.example.demo.controllers;

import com.example.demo.entities.Customers;
import com.example.demo.services.CustomersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    CustomersServices customersServices;

    @PostMapping("/create")
    public ResponseEntity<Customers> createCustomer(@RequestBody Customers customer){
        return  customersServices.createACustomer(customer);
    }

    @GetMapping("/get-one")
    public ResponseEntity<Customers> getSingleCustomer(long id){
        return customersServices.getOneCustomer(id);
    }

    @GetMapping("/get-list")
    public List<Customers> getListCustomers(){
       return customersServices.findAllCustomers();
    }

    @PutMapping("/update")
    public ResponseEntity<Customers> modifyCustomer(long id, Customers customer){
        return customersServices.updateCustomer(id,customer);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Customers> deleteOneCostumer(long id){
        return customersServices.deleteCustomer(id);
    }

}
