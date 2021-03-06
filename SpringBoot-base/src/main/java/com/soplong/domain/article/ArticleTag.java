package com.soplong.domain.article;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class ArticleTag implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer tagId;

    private Integer articleId;

    private Integer delFlag;
}
