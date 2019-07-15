package com.gara.springbootjdbcdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Customer
 * @description: 测试类
 * @author: GaraYing
 * @create: 2019-01-02 15:56
 * @Version: 1.0
 **/
@Data  // 生成无参构造方法/getter/setter/hashCode/equals/toString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private long id;

    private String firstname;
    private String lastname;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
