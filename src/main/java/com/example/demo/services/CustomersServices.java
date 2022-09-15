package com.example.demo.services;

import com.example.demo.controllers.CustomersController;
import com.example.demo.entities.Customers;
import com.example.demo.repositories.CustomersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersServices {

    Logger logger = LoggerFactory.getLogger(CustomersServices.class);

    @Autowired
    private CustomersRepository customersRepository;

    public ResponseEntity<Customers> createACustomer(Customers customers){
        logger.debug("This method create a new customer in CustomerService");
        customersRepository.saveAndFlush(customers);
        return new ResponseEntity<>(customers, HttpStatus.CREATED);
    }

    public List<Customers> findAllCustomers(){
        logger.debug("This method get a list of all customers in CustomerService");
        return customersRepository.findAll();
    }

    public ResponseEntity<Customers> getOneCustomer(long id){
        logger.debug("This method get one customer in CustomerService by id");
        if(customersRepository.existsById(id)){
            return new ResponseEntity<>(customersRepository.getReferenceById(id),HttpStatus.OK);
        }
        else
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Customers> updateCustomer(long id,Customers customers){
        logger.debug("This method update a customer in CustomerService");
        if(customersRepository.existsById(id)){
            customersRepository.saveAndFlush(customers);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Customers> deleteCustomer(long id){
        logger.debug("This method delete a customer in CustomerService by id");
        if(customersRepository.existsById(id)){
            customersRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }



}
