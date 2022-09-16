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
@Table(name = "customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_customer",length = 50)
    private Long idCustomer;

    @Column(name = "name",length = 50)
    private String name;

    @Column(name = "surname",length = 50)
    private String surname;

    @Column(name = "email",length = 50)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "customers")
    private List<Orders> listOrdersCustomer;

}
