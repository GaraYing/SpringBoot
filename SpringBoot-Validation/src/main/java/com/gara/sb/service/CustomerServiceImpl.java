package com.gara.sb.service;

import com.gara.sb.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @description:
 * @createTime: 2019-10-08 10:10
 * @Version: 4.0
 **/
@Service
public class CustomerServiceImpl implements CustomerService{

    private Map<Long, Customer> repository = new ConcurrentHashMap<>();

    private final AtomicLong atomicLong = new AtomicLong();

    @Override
    public void testSuperBuilder() {
        Customer customer = Customer.builder()
                .customerId(0L)
                .resource("测试")
                .id(0L)
                .name("测试机")
                .cardNum("1234")
                .build();
        System.out.println(customer.toString());
    }

    @Override
    public Customer addCustomer(Customer customer) {
        long id = atomicLong.incrementAndGet();
        customer.setCustomerId(id);
        repository.put(id, customer);
        return repository.get(id);
    }
}
