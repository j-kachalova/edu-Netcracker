package org.example.NC.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class OrderSIM {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer idEmployee;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;
    private Integer num;

    public OrderSIM(Integer idEmployee, Address address, Integer num) {
        this.idEmployee = idEmployee;
        this.address = address;
        this.num = num;
    }

    public OrderSIM() {

    }
}
