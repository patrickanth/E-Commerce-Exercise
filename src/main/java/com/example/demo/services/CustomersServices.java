package com.example.demo.services;

import com.example.demo.entities.Customers;
import com.example.demo.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersServices {

    @Autowired
    private CustomersRepository customersRepository;

    public ResponseEntity<Customers> createACustomer(Customers customers){
        customersRepository.saveAndFlush(customers);
        return new ResponseEntity<>(customers, HttpStatus.CREATED);
    }

    public List<Customers> findAllCustomers(){
        return customersRepository.findAll();
    }

    public ResponseEntity<Customers> getOneCustomer(long id){
        if(customersRepository.existsById(id)){
            return new ResponseEntity<>(customersRepository.getReferenceById(id),HttpStatus.OK);
        }
        else
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Customers> updateCustomer(long id,Customers customers){
        if(customersRepository.existsById(id)){
            customersRepository.saveAndFlush(customers);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Customers> deleteCustomer(long id){
        if(customersRepository.existsById(id)){
            customersRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
