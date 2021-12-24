package com.dilmurod.kapitalbank.service;

import com.dilmurod.kapitalbank.entity.*;
import com.dilmurod.kapitalbank.payload.ApiResponse;
import com.dilmurod.kapitalbank.payload.OrderDto;
import com.dilmurod.kapitalbank.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    DetailRepository detailRepository;


    public ApiResponse getByCustomer(Integer id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (!optionalCustomer.isPresent()) return new ApiResponse("Customer does not exists!",false);

        List<Order> allByCustomer_id = orderRepository.findAllByCustomer_Id(id);
        return new ApiResponse("Success!",true,allByCustomer_id);

    }

    public ApiResponse getAllOrderByDate(Date dateFrom, Date dateTo) {
        List<Order> allByDateBetween = orderRepository.findAllByDateBetween(dateFrom, dateTo);
        return new ApiResponse("Success",true,allByDateBetween);
    }

    public ApiResponse getLastOrders() {
        List<?> lastOrders = orderRepository.getLastOrders();
        return new ApiResponse("Success",true,lastOrders);
    }

    public ApiResponse add(OrderDto orderDto) {
        Optional<Customer> optionalCustomer = customerRepository.findById(orderDto.getCustomerId());
        if (!optionalCustomer.isPresent()) return new ApiResponse("Not Customer", false);


        Optional<Product> optionalProduct = productRepository.findById(orderDto.getProductId());
        if (!optionalProduct.isPresent()) return new ApiResponse("Not Found", false);

        Order order = new Order();
        order.setCustomer(optionalCustomer.get());
        order.setDate(new Date());

        orderRepository.save(order);

        Detail detail = new Detail();
        detail.setOrder(order);
        detail.setProduct(optionalProduct.get());
        detail.setQuantity(orderDto.getQuantity());
        detailRepository.save(detail);

        Invoice invoice = new Invoice();
        invoice.setIssued(new Date());

        Date dt1 = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt1);
        calendar.add(Calendar.DATE, 7);
        dt1 = calendar.getTime();

        invoice.setDue(dt1);
        invoice.setOrder(order);
        Double sum =  detail.getQuantity()*detail.getProduct().getPrice();
        invoice.setAmount(sum);
        invoiceRepository.save(invoice);

        return new ApiResponse("Saved", true);
    }

    public ApiResponse getOrdersWithoutDetails() {
        Date date = new Date();
        List<?> ordersWithoutDetails = orderRepository.getOrdersWithoutDetails(date);
        return new ApiResponse("Success", true, ordersWithoutDetails);
    }

    public ApiResponse getNumberOfProductsInYear() {
        List<?> numberOfProductsInYear = orderRepository.getNumberOfProductsInYear();
        return new ApiResponse("Success", true, numberOfProductsInYear);
    }
}
