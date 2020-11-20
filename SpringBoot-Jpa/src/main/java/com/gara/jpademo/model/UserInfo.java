package com.gara.jpademo.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * user_info
 * @author 
 */
@Table(name="user_info")
@Data
@Builder
@Entity
public class UserInfo implements Serializable {

    @Tolerate
    public UserInfo() {
    }

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    @Column(name = "username", nullable = false)
    private String userName;

    /**
     * 密码
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * 用户类型
     */
    @Column(name = "usertype", nullable = false)
    private String usertype;

    /**
     * 是否可用
     */
    @Builder.Default
    @Column(name = "enabled", nullable = false)
    private Integer enabled = 1;

    /**
     * 真实姓名
     */
    @Column(name = "realname", nullable = false)
    private String realname;

    /**
     * QQ
     */
    @Column(name = "qq", nullable = false)
    private String qq;

    @Column(name = "email", nullable = false)
    private String email;

    /**
     * 联系电话
     */
    @Column(name = "tel")
    private String tel;

    private static final long serialVersionUID = 1L;

    @OneToMany(targetEntity = UserRole.class)
    private List<UserRole> userRoles;


    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", usertype='" + usertype + '\'' +
                ", enabled=" + enabled +
                ", realname='" + realname + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}