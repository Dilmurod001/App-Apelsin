package com.dilmurod.kapitalbank.entity;

import com.dilmurod.kapitalbank.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order extends AbsEntity {
    private Date date;

    @ManyToOne
    private Customer customer;
}
