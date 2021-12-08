package org.example.NC.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer idCategory;
    private String name;
    private Integer price;

   /* @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCategory")
    private TariffСategory tariffСategory;*/

    /*public String getTariffСategoryName(){
        return tariffСategory.getName();
    }*/
}
