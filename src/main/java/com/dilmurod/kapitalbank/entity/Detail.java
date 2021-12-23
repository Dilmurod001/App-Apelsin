package com.dilmurod.kapitalbank.entity;

import com.dilmurod.kapitalbank.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Detail extends AbsEntity {
    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    private Integer quantity;
}
