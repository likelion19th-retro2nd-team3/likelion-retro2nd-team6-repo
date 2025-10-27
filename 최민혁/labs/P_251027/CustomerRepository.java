package com.members.최민혁.labs.P_251027;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //고객의 세부 정보와 그 고객의 가장 최근 주문을 조회
    @Query("select c.id, c.name, c.age, o.date from Customer c left join c.orders o on o.date =" +
            "(select max(o2.date) from c.orders o2)")
    Optional<Object> findCustomerOrderByDate();


    //평균나이보다 많은 고객을 조회
    @Query("select id, name, age from Customer where age > (select avg(age) from Customer)")
    List<Object[]> findCustomerAvgAge();


    //특정 물건을 주문한 고객의 리스트를 조회
    @Query("select c.id, c.name, c.orders, o.product from Customer c left join c.orders o where o.product = :product")
    List<Object[]> findCustomerBuyingProduct(@Param("product")String product);
}
