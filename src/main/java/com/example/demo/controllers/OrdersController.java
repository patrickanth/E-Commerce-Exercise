package com.example.demo.controllers;


import com.example.demo.entities.Orders;
import com.example.demo.services.OrdersServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    Logger logger = LoggerFactory.getLogger(OrdersController.class);
    @Autowired
    private OrdersServices ordersServices;
    @PostMapping("/create")
    public ResponseEntity<Orders> createOrder(long idCustomer, long idItems , @RequestBody Orders order){
        logger.info("creating a order in controller");
        return  ordersServices.createAOrder(idCustomer,idItems,order);
    }
    @GetMapping("/get-one")
    public ResponseEntity<Orders> getSingleOrder(long id){
        logger.info("getting one order in controller");
        return ordersServices.getOneOrder(id);
    }
    @GetMapping("/get-list")
    public List<Orders> getListOrders(){
        logger.info("getting a list of orders in controller");
        return ordersServices.findAllOrders();
    }
    @PutMapping("/update")
    public ResponseEntity<Orders> modifyOrder(long idCustomer, long idItem, long idOrder, Orders orderChanged){
        logger.info("updating a order in controller");
        return ordersServices.updateOrder(idCustomer,idItem,idOrder,orderChanged);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Orders> deleteOneOrder (long idCustomer, long idItem , long idOrder){
        logger.info("deleting a order in controller");
        return ordersServices.deleteOrder(idCustomer,idItem,idOrder);
    }

}
