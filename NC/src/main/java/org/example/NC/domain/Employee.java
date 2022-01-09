package org.example.NC.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;


@ToString
@Entity

@Getter
@Setter
public class Employee extends Human {
    /**
     * Operation's account.
     */

    @Column(nullable = false, updatable = false)
    private Integer accountId;

    /**
     * Operation's amount.
     */

    @Column(nullable = false, updatable = false, scale = 2, precision = 10)
    private BigDecimal amount;
}
