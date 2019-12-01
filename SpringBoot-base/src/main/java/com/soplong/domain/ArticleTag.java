package com.soplong.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ArticleTag implements Serializable {

    private Integer id;

    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 删除标记 【0】正常 【1】删除
     */
    private Integer delFlag;
}
