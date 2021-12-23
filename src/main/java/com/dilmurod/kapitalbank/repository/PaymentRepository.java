package com.dilmurod.kapitalbank.repository;

import com.dilmurod.kapitalbank.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    @Query(value = "select * from payment where invoice_id=(select o.id from invoice i natural join orders o where o.id=:orderId)",nativeQuery = true)
    List<Payment>findAllByOrderId(@RequestParam("orderId") Integer orderId);
}
