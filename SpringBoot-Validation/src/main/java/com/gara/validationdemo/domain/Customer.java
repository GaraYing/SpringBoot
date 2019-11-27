package com.gara.validationdemo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * @description:
 * @createTime: 2019-10-08 10:06
 * @Version: 4.0
 **/
@SuperBuilder
@Getter
@Setter
@ToString(callSuper = true)
public class Customer extends User {

    private Long customerId;

    private String resource;

}
