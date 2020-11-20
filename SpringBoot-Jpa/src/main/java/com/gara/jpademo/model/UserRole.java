package com.gara.jpademo.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * user_role
 *
 * @author
 */
@Table(name = "user_role")
@Data
@Entity
@Builder
public class UserRole implements Serializable {
    @Tolerate
    public UserRole() {
    }

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "userroles", nullable = false)
    private String userroles;

    @Column(name = "createtime", nullable = false)
    private Date createtime;

    @Column(name = "updatetime", nullable = false)
    private Date updatetime;

    @ManyToOne(targetEntity = UserInfo.class)
    private UserInfo userInfo;

    private static final long serialVersionUID = 1L;
}