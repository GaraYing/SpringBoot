package com.gara.sb.validation.constraints;

import lombok.Getter;

@Getter
public enum StatusEnum {
    DISABLE(0,"禁用/已删除"),
    ENABLE(1,"启用");

    private Integer code;

    private String value;

    StatusEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
    
    public static boolean isDisable(Integer code){
        return StatusEnum.DISABLE.getCode().equals(code);
    }

    public static boolean isEnable(Integer code){
        return StatusEnum.ENABLE.getCode().equals(code);
    }

    public static boolean isValidValue(Integer code){
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (statusEnum.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }
}
