package com.gara.sb.controller;

import com.gara.sb.domain.Customer;
import com.gara.sb.service.CustomerService;
import com.gara.sb.validation.CustomerGroup;
import com.gara.sbcommon.result.Result;
import com.gara.sbcommon.result.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @createTime: 2019-10-08 10:13
 * @Version: 4.0
 **/
@RestController
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/test/group/validate")
    public Result<Customer> testGroupValidate(@RequestBody @Validated({CustomerGroup.class}) Customer customer){
      log.info("request params is: {}", customer.toString() );
        return ResultGenerator.genSuccessResult(customerService.addCustomer(customer));
    }

    @GetMapping("testSuperBuilder")
    public String testSuperBuilder() {
        customerService.testSuperBuilder();
        return "success";
    }
}
