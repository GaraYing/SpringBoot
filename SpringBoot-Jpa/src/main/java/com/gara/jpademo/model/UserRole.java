package com.gara.jpademo.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    public UserRole() {
    }

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "userroles", nullable = false)
    private String userroles;

    @Column(name = "createtime", nullable = false)
    private Date createtime;

    @Column(name = "updatetime", nullable = false)
    private Date updatetime;

    private static final long serialVersionUID = 1L;
}