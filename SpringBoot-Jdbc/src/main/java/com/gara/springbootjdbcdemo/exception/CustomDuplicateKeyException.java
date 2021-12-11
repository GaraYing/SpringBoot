package com.gara.springbootjdbcdemo.exception;

import org.springframework.dao.DuplicateKeyException;

/**
 * @author GARA
 * @date 2021/12/12 0:03
 */
public class CustomDuplicateKeyException extends DuplicateKeyException {
    public CustomDuplicateKeyException(String msg) {
        super(msg);
    }

    public CustomDuplicateKeyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
