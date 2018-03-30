package com.gara.yz.sb_log.web;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 小哥哥加点注释吧~~
 *
 * @author Gary
 * @date 2018/03/30 15:13
 */

public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
