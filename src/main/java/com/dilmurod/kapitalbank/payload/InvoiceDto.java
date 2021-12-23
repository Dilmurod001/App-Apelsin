package com.dilmurod.kapitalbank.payload;

import com.dilmurod.kapitalbank.entity.Order;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class InvoiceDto {
    private Integer orderId;

    private double amount;

    private Date issued;

    private Date due;
}
