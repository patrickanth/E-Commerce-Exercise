package com.example.demo.services;

import com.example.demo.entities.Customers;
import com.example.demo.entities.Items;
import com.example.demo.entities.Orders;
import com.example.demo.repositories.CustomersRepository;
import com.example.demo.repositories.ItemsRepository;
import com.example.demo.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServices {

    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private CustomersRepository customersRepository;
    @Autowired
    private ItemsRepository itemsRepository;

    private EmailService emailService;

    public ResponseEntity<Orders> createAOrder(long idCustomer, long idItems,Orders newOrder){
        if (customersRepository.existsById(idCustomer) && itemsRepository.existsById(idItems)){
            ordersRepository.saveAndFlush(newOrder);
            Customers customer = customersRepository.getReferenceById(idCustomer);
            emailService.sendEmail(customer.getEmail(), "Order",
                    "Dear " + customer.getName() + " " + customer.getSurname() + " ,the order was accepted");
            return new ResponseEntity<>(newOrder, HttpStatus.CREATED);

        }
       else
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public List<Orders> findAllOrders(){
        return ordersRepository.findAll();
    }

    public ResponseEntity<Orders> getOneOrder(long id){
        if(ordersRepository.existsById(id)){
            return new ResponseEntity<>(ordersRepository.getReferenceById(id),HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Orders> updateOrder(long idCustomer, long idItem, long idOrder, Orders orderChanged)
    {
        if(ordersRepository.existsById(idOrder)&& customersRepository.existsById(idCustomer) &&
                itemsRepository.existsById(idItem)){
            ordersRepository.saveAndFlush(orderChanged);
            Customers customer = customersRepository.getReferenceById(idCustomer);
            emailService.sendEmail(customer.getEmail(), "Order Changed",
                    "Dear " + customer.getName() + customer.getSurname() + " ,the order was successfully updated");
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Orders> deleteOrder(long idCustomer, long idItem , long idOrder){
        if(customersRepository.existsById(idCustomer) && itemsRepository.existsById(idItem)
                && ordersRepository.existsById(idOrder)){
            ordersRepository.deleteById(idOrder);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
