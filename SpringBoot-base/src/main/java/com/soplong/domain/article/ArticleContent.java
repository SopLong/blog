package com.soplong.domain.article;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class ArticleContent implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String content;

    private Integer articleId;

    private Integer delFlag;
}
