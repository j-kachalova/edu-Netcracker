package org.example.NC.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class BuyingDTO {
    private Human user;
    private Tariff tariff;
    private String number;
    private String kind;
    private Integer price;
    private String payment;
}
