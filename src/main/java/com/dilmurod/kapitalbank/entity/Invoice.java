package com.dilmurod.kapitalbank.entity;

import com.dilmurod.kapitalbank.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Invoice extends AbsEntity {
    @OneToOne
    private Order order;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private Date issued;

    @Column(nullable = false)
    private Date due;

}
