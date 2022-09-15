package com.example.demo.controllers;

import com.example.demo.entities.Customers;
import com.example.demo.services.CustomersServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    CustomersServices customersServices;

    Logger logger = LoggerFactory.getLogger(CustomersController.class);


    @PostMapping("/create")
    public ResponseEntity<Customers> createCustomer(@RequestBody Customers customer){
        logger.info("starting creation customer in controller");
        return  customersServices.createACustomer(customer);
    }

    @GetMapping("/get-one")
    public ResponseEntity<Customers> getSingleCustomer(long id){
        logger.info("getting one costumer in controller");
        return customersServices.getOneCustomer(id);
    }

    @GetMapping("/get-list")
    public List<Customers> getListCustomers(){
        logger.info("getting list customers in controller");
       return customersServices.findAllCustomers();
    }

    @PutMapping("/update")
    public ResponseEntity<Customers> modifyCustomer(long id, Customers customer){
        logger.info("updating a customer in controller");
        return customersServices.updateCustomer(id,customer);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Customers> deleteOneCostumer(long id){
        logger.info("deleting a customer in controller");
        return customersServices.deleteCustomer(id);
    }

}
