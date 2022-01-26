package org.example.NC.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class NumberSIM {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String num;
    private boolean isUsed;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;
}
