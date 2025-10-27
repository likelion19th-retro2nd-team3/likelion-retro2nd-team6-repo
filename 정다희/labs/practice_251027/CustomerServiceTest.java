package com.members.정다희.labs.practice_251027;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;

    @Test
    void getCustomers() {
        List<Customer> customers = customerService.getCustomers();
        assertThat(customers.size()).isEqualTo(10);
    }

    @Test
    void getCustomer() {
        Customer customer = customerService.getCustomer(1L);
        assertThat(customer).isNotNull();
    }

    @Test
    void getCustomerByEmail() {
        Customer customer = customerService.getCustomerByEmail("hong@example.com");
        assertThat(customer.getId()).isNotNull();
        assertThat(customer.getName()).isEqualTo("홍길동");
    }

    @Test
    void getCustomerByEmailNotFound() {
        // 예외가 제대로 발생되는지 확인
        assertThatThrownBy(() -> customerService.getCustomerByEmail("notfound"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createCustomer() {
        Long id = customerService.createCustomer("test", "test@gmail.com", 20);

        Customer customer = customerService.getCustomer(id);
        assertThat(customer).isNotNull();
        assertThat(customer.getName()).isEqualTo("test");
        assertThat(customer.getEmail()).isEqualTo("test@gmail.com");
    }

    @Test
    void updateCustomer() {
        Customer customer = new Customer("홍동길", "hongdong@example.com", 30);
        customer.setId(1L);

        Customer updateCustomer = customerService.updateCustomer(customer);
        assertThat(updateCustomer.getName()).isEqualTo("홍동길");
        assertThat(updateCustomer.getEmail()).isEqualTo("hongdong@example.com");
        assertThat(updateCustomer.getAge()).isEqualTo(30);
    }

    @Test
    void deleteCustomer() {
        customerService.deleteCustomer(1L);
        assertThatThrownBy(() -> customerService.getCustomer(1L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Customer with id 1 not found!");
    }

    @Test
    void findOrderCountOfCustomer() {
        List<Object[]> results = customerService.findOrderCountOfCustomer();

        for (Object[] row : results) {
            Customer customer = (Customer) row[0];
            Long orderCount = (Long) row[1];

            System.out.printf(
                    "고객 ID: %d | 이름: %s | 주문 수: %d%n",
                    customer.getId(),
                    customer.getName(),
                    orderCount
            );
        }
    }

    @Test
    void findAllCustomersWithLatestOrder() {
        List<Object[]> results = customerService.findAllCustomersWithLatestOrder();

        for (Object[] row : results) {
            Customer customer = (Customer) row[0];
            Order order = (Order) row[1];

            if (order == null) {
                System.out.printf(
                        "고객 ID: %d | 이름: %s | 최근 주문: 없음%n",
                        customer.getId(),
                        customer.getName()
                );
            } else {
                System.out.printf(
                        "고객 ID: %d | 이름: %s | 주문 ID: %d | 주문 상품: %s | 주문 날짜: %s%n",
                        customer.getId(),
                        customer.getName(),
                        order.getId(),
                        order.getProduct(),
                        order.getDate()
                );
            }
        }
    }

    @Test
    void findCustomersOlderThanAvg() {
        List<Customer> customers = customerService.findCustomersOlderThanAvg();

        for (Customer customer : customers) {
            System.out.printf(
                    "고객 ID: %d | 이름: %s | 나이: %d%n",
                    customer.getId(),
                    customer.getName(),
                    customer.getAge()
            );
        }
    }

    @Test
    void findCustomersByProduct() {
        List<Object[]> customers = customerService.findCustomerByProduct("키보드");
        for (Object[] row : customers) {
            Customer customer = (Customer) row[0];
            Order order = (Order) row[1];

            System.out.printf(
                    "고객 ID: %d | 이름: %s | 상품명: %s%n",
                    customer.getId(),
                    customer.getName(),
                    order.getProduct()
            );
        }
    }
}