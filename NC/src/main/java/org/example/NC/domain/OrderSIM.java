package org.example.NC.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order")
public class OrderSIM {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer idEmployee;
    private Integer idAddress;
    private Integer num;
}
