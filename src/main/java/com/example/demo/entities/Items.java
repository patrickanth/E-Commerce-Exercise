package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_items",length = 50)
    private Long idItem;

    @Column(name = "item_type",length = 50)
    private String itemType;

    @Column(name = "price",length = 50)
    private double price;

    @JsonIgnore
    @OneToMany(mappedBy = "items")
    private List<Orders> listOrdersItems;
}
