package com.members.최민혁.labs.P_251027;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Optional<Object> getCustomerByDate(){
        Optional<Object> customerOrderByDate = customerRepository.findCustomerOrderByDate();
        return customerOrderByDate;
    }
    public List<Object[]> getCustomerByOverAvgAge(){
        List<Object[]> customerAvgAge = customerRepository.findCustomerAvgAge();
        return customerAvgAge;
    }

    public List<Object[]> getCustomerBuyingProduct(String product){
        List<Object[]> customerBuyingProduct = customerRepository.findCustomerBuyingProduct(product);
        return customerBuyingProduct;
    }


}
}
