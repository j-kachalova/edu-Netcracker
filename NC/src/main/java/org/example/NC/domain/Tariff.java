package org.example.NC.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category")
    private TariffСategory category;
    private String name;
    private Integer price;

   /* @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCategory")
    private TariffСategory tariffСategory;*/

    /*public String getTariffСategoryName(){
        return tariffСategory.getName();
    }*/
}
