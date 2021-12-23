package com.dilmurod.kapitalbank.repository;

import com.dilmurod.kapitalbank.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "select d.quantity,p.name,p.price,p.price*d.quantity as sum  from orders o natural join detail d natural join product p where o.customer_id=:customers_id",nativeQuery = true)
    List<?> getAllInfo(@RequestParam("customers_id") Integer customers_id);

    @Query(value = "select p.name from orders inner join detail d on orders.id = d.order_id inner join product p on d.product_id = p.id where d.quantity>=10",nativeQuery = true)
    List<?>getSoldProductMoreThanTen();

    @Query(value = "select p.name,p.price from product p natural join detail d where d.quantity>=8",nativeQuery = true)
    List<?>getAllByQuantity();

    @Query(value = "select p.name from product p order by p.price desc limit 10",nativeQuery = true)
    List<?>getTenExpensive();
}
