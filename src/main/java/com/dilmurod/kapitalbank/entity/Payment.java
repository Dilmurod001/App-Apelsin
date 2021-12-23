package com.dilmurod.kapitalbank.entity;

import com.dilmurod.kapitalbank.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.security.Timestamp;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Payment extends AbsEntity {
    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private Double amount;

    @ManyToOne
    private Invoice invoice;
}
