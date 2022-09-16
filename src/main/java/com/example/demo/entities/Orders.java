package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_orders",length = 50)
    private Long idOrder;

    @Column(name = "id_items",length = 50)
    private int idItem;

    @Column(name = "id_customer",length = 50)
    private int idCustomer;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id_customer",referencedColumnName = "id_customer",insertable = false, updatable = false)
    private Customers customers;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id_items",referencedColumnName = "id_items",insertable = false, updatable = false)
    private Items items;
}
