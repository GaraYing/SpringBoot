package com.gara.sb.controller;

import com.gara.sb.domain.Customer;
import com.gara.sb.service.CustomerService;
import com.gara.sb.validation.CustomerGroup;
import com.gara.sb.validation.ValidList;
import com.gara.sbcommon.result.Result;
import com.gara.sbcommon.result.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @createTime: 2019-10-08 10:13
 * @Version: 4.0
 **/
@RestController
@Slf4j
@Validated
@RequestMapping(value = "/validate")
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

    @PostMapping(value = "/test/list/validate")
    public Result<List<Customer>> testListValidate(@RequestBody @Validated ValidList<Customer> customers) {
        log.info("request params is: {}", customers );
        return ResultGenerator.genSuccessResult(customers);
    }
}
