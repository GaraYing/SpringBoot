package com.gara.sb.domain;

import com.gara.sb.validation.CustomerGroup;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @description:
 * @createTime: 2019-10-08 10:06
 * @Version: 4.0
 **/
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Customer extends User {

    private Long customerId;

    @NotNull(message = "resource不能为空", groups = CustomerGroup.class)
    @NotEmpty(message = "resource不能为空", groups = CustomerGroup.class)
    private String resource;
}
