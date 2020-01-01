package com.soplong.domain.article;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class ArticleContent implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * html格式内容
     */
    private String content;

    /**
     * md格式内天
     */
    private String mdContent;

    private Integer articleId;

    private Integer delFlag;
}
