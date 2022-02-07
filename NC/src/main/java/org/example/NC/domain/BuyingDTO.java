package org.example.NC.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyingDTO {
    private String number;
    private String kind;
    private Integer price;
    private Tariff tariff;
}
