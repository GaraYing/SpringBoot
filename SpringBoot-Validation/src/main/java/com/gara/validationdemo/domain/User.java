package com.gara.validationdemo.domain;

import com.gara.validationdemo.validation.constraints.ValidCardNum;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@SuperBuilder
@Data
public class User {

    @Max(value = 10000)
    private Long id;

    @NotNull(message = "姓名不能为空")
    private String name;

    @NotNull
//    @ValidCardNum(message = "卡号必须以\"GARA\"开头 , 以数字结尾")
    @ValidCardNum
    private String cardNum;
}
