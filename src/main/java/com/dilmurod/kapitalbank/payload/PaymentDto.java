package com.dilmurod.kapitalbank.payload;

import com.dilmurod.kapitalbank.entity.Invoice;
import lombok.Data;

@Data
public class PaymentDto {
    private Data data;
    private Double amount;
    private Integer invoiceId;
}
