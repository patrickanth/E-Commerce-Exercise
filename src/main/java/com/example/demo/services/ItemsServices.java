package com.example.demo.services;

import com.example.demo.controllers.CustomersController;
import com.example.demo.entities.Customers;
import com.example.demo.entities.Items;
import com.example.demo.repositories.CustomersRepository;
import com.example.demo.repositories.ItemsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServices {

    Logger logger = LoggerFactory.getLogger(ItemsServices.class);
    @Autowired
    private ItemsRepository itemsRepository;

    public ResponseEntity<Items> createAItem(Items items){
        logger.debug("This method create a new Item in ItemsServices");
        itemsRepository.saveAndFlush(items);
        return new ResponseEntity<>(items, HttpStatus.CREATED);
    }

    public List<Items> findAllItems(){
        logger.debug("This method find all item in ItemsServices");
        return itemsRepository.findAll();
    }

    public ResponseEntity<Items> getOneItem(long id){
        logger.debug("This method find one item in ItemsServices by id");
        if(itemsRepository.existsById(id)){
            return new ResponseEntity<>(itemsRepository.getReferenceById(id),HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Items> updateItems(long id,Items items){
        logger.debug("This method update one item in ItemsServices");
        if(itemsRepository.existsById(id)){
            itemsRepository.saveAndFlush(items);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Items> deleteItem(long id){
        logger.debug("This method delete one item in ItemsServices by id");
        if(itemsRepository.existsById(id)){
            itemsRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
