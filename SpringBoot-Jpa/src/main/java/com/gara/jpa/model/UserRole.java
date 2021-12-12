package com.gara.jpa.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

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
    @Tolerate
    public UserRole() {
    }

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "username", nullable = false)
//    private String userName;

    @Column(name = "userroles", nullable = false)
    private String userroles;

    @Column(name = "createtime", nullable = false)
    private Date createtime;

    @Column(name = "updatetime", nullable = false)
    private Date updatetime;

    // 这里设置 FetchType = lazy,获取时才会发起SQL查询
    @JsonIgnore
    @JSONField(serialize = false)
    @ManyToOne(targetEntity = UserInfo.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_info_id", referencedColumnName = "id")
    private UserInfo userInfo;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", userroles='" + userroles + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                '}';
    }
}