package com.gara.validationdemo.service;

import com.gara.validationdemo.domain.Customer;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @createTime: 2019-10-08 10:10
 * @Version: 4.0
 **/
@Service
public class customerServiceImpl implements CustomerService{
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
}
