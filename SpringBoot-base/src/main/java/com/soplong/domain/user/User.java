package com.soplong.domain.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private String name;

    private String fullName;

    private String password;

    private Date createtime;

    /**
     * 是否有效 1有效 0无效
     */
    private Integer isEffective;

    /**
     * 头像
     */
    private String profile;
}
