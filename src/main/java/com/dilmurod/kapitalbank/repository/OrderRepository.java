package com.dilmurod.kapitalbank.repository;

import com.dilmurod.kapitalbank.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    List <Order> findAllByCustomer_Id(Integer customer_id);
    List <Order> findAllByDateBetween(Date from, Date to);

    @Query(value = "select customer.full_name,o.date,p.name from customer  inner join orders o on customer.id = o.customer_id inner join detail d on o.id = d.order_id inner join product p on d.product_id = p.id order by o.date desc limit 1",nativeQuery = true)
    List<?> getLastOrders();

    List<?> getOrdersWithoutDetails(Date date);
}
