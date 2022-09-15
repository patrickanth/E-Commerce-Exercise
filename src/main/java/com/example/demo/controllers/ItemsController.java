package com.example.demo.controllers;

import com.example.demo.entities.Customers;
import com.example.demo.entities.Items;
import com.example.demo.services.CustomersServices;
import com.example.demo.services.ItemsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    ItemsServices itemsServices;
    @PostMapping("/create")
    public ResponseEntity<Items> createItem(@RequestBody Items item){
        return  itemsServices.createAItem(item);
    }
    @GetMapping("/get-one")
    public ResponseEntity<Items> getSingleItem(long id){
        return itemsServices.getOneItem(id);
    }
    @GetMapping("/get-list")
    public List<Items> getListItems(){
        return itemsServices.findAllItems();
    }

    @PutMapping("/update")
    public ResponseEntity<Items> modifyItem(long id, Items item){
        return itemsServices.updateItems(id,item);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Items> deleteOneItem(long id){
        return itemsServices.deleteItem(id);
    }
}
