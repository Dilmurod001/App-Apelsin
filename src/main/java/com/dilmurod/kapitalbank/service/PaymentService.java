package com.dilmurod.kapitalbank.service;

import com.dilmurod.kapitalbank.entity.Invoice;
import com.dilmurod.kapitalbank.entity.Order;
import com.dilmurod.kapitalbank.entity.Payment;
import com.dilmurod.kapitalbank.payload.ApiResponse;
import com.dilmurod.kapitalbank.payload.PaymentDto;
import com.dilmurod.kapitalbank.repository.InvoiceRepository;
import com.dilmurod.kapitalbank.repository.OrderRepository;
import com.dilmurod.kapitalbank.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    InvoiceRepository invoiceRepository;


    public ApiResponse getAllByOrderId(Integer id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (!optionalOrder.isPresent()) return new ApiResponse("Order does not exists!",false);

        List<Payment> allByOrderId = paymentRepository.findAllByOrderId(id);
        return new ApiResponse("Success",true,allByOrderId);

    }

    public ApiResponse addPayment(PaymentDto paymentDto) {
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(paymentDto.getInvoiceId());
        if (!optionalInvoice.isPresent()) return new ApiResponse("Not Found",false);

        Payment payment = new Payment();
        payment.setInvoice(optionalInvoice.get());
        payment.setAmount(optionalInvoice.get().getAmount());
        payment.setDate(new Date());
        paymentRepository.save(payment);
        return new ApiResponse("Success",true,payment);
    }

    public ApiResponse getDetails(Integer id) {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        if (!optionalPayment.isPresent()) return new ApiResponse("Not Found",false);
        return new ApiResponse("Success",true,optionalPayment.get());
    }

}
