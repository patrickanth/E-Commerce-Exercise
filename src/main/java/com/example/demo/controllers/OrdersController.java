package com.example.demo.controllers;

import com.example.demo.entities.Customers;
import com.example.demo.entities.Orders;
import com.example.demo.services.OrdersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersServices ordersServices;
    @PostMapping("/create")
    public ResponseEntity<Orders> createOrder(long idCustomer, long idItems ,@RequestBody Orders order){
        return  ordersServices.createAOrder(idCustomer,idItems,order);
    }
    @GetMapping("/get-one")
    public ResponseEntity<Orders> getSingleOrder(long id){
        return ordersServices.getOneOrder(id);
    }
    @GetMapping("/get-list")
    public List<Orders> getListOrders(){
        return ordersServices.findAllOrders();
    }
    @PutMapping("/update")
    public ResponseEntity<Orders> modifyOrder(long idCustomer, long idItem, long idOrder, Orders orderChanged){
        return ordersServices.updateOrder(idCustomer,idItem,idOrder,orderChanged);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Orders> deleteOneOrder (long idCustomer, long idItem , long idOrder){
        return ordersServices.deleteOrder(idCustomer,idItem,idOrder);
    }

}
