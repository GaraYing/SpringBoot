package com.gara.sb.domain;

import com.gara.sb.validation.constraints.ValidCardNum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Max(value = 10000)
    private Long id;

    @NotNull(message = "姓名不能为空")
    private String name;

    @NotNull
//    @ValidCardNum(message = "卡号必须以\"GARA\"开头 , 以数字结尾")
    @ValidCardNum
    private String cardNum;
    /**
     * 嵌套校验属性必须用  {@link Valid} 修饰
      */
    @Valid
    private Profile profile;

    @Data
    static class Profile{

        @NotNull(message = "头像不能为空")
        private String photo;
    }
}
