package com.members.정다희.labs.practice_251027;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);

    // 각 고객과 고객이 가진 주문 수
    @Query("SELECT c, count(o) FROM Customer c LEFT JOIN c.orders o GROUP BY c")
    List<Object[]> findOrderCountOfCustomer();

    // 고객의 세부 정보와 그 고객이 가장 최근 주문을 조회
    @Query("""
        SELECT c, o
        FROM Customer c
        LEFT JOIN c.orders o
        ON o.date = (
            SELECT MAX(o2.date)
            FROM Order o2
            WHERE o2.customer = c
        )
    """)
    List<Object[]> findAllCustomersWithLatestOrder();

    // 평균 나이 보다 많은 고객을 조회
    @Query("""
        SELECT c
        FROM Customer c
        WHERE c.age > (
            SELECT AVG(c2.age)
            FROM Customer c2
        )
    """)
    List<Customer> findCustomersOlderThanAvg();

    // 특정 물건을 주문한 고객의 리스트를 조회
    @Query("""
        SELECT c, o
        FROM Customer c
        INNER JOIN c.orders o
        ON o.product = :product
    """)
    List<Object[]> findCustomersByProduct(@Param("product") String product);
}
