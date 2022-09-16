package com.example.demo.controllers;

import com.example.demo.entities.Items;
import com.example.demo.services.ItemsServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController {

    Logger logger = LoggerFactory.getLogger(ItemsController.class);
    @Autowired
    ItemsServices itemsServices;
    @PostMapping("/create")
    public ResponseEntity<Items> createItem(@RequestBody Items item){
        logger.info("creating a item in controller");
        return  itemsServices.createAItem(item);
    }
    @GetMapping("/get-one")
    public ResponseEntity<Items> getSingleItem(long id){
        logger.info("getting a single item in controller");
        return itemsServices.getOneItem(id);
    }
    @GetMapping("/get-list")
    public List<Items> getListItems(){
        logger.info("getting a list of items in controller");
        return itemsServices.findAllItems();
    }

    @PutMapping("/update")
    public ResponseEntity<Items> modifyItem(long id, Items item){
        logger.info("updating a item in controller");
        return itemsServices.updateItems(id,item);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Items> deleteOneItem(long id){
        logger.info("deleting a item in controller");
        return itemsServices.deleteItem(id);
    }
}
