package com.dilmurod.kapitalbank.service;

import com.dilmurod.kapitalbank.payload.ApiResponse;
import com.dilmurod.kapitalbank.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;
    public ApiResponse getInvoiceIssued() {
        List<?> allByIssued = invoiceRepository.getAllByIssued();
        return new ApiResponse("Success",true,allByIssued);

    }
}
