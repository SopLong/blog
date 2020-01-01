package com.soplong.domain.article;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ArticleInfo implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 简介
     */
    private String summary;

    /**
     * 是否置顶 【0】否 【1】是
     */
    private Integer isTop;

    /**
     * 文章访问量
     */
    private Integer traffic;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 删除标记 【0】正常 【1】删除
     */
    private Integer delFlag;

    /**
     * 图片路径
     */
    private String imgUrl;

    /**
     * 是否发布 【0】未发布 【1】已发布
     */
    private Integer isPost;

    /**
     * 发布时间
     */
    private Date postTime;
}
