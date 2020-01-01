package com.soplong.domain.article.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.soplong.domain.article.ArticleInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ArticleListVO extends ArticleInfo implements Serializable {

    /**
     * 标签列表
     */
    @TableField(exist = false)
    private List<String> tagNames;

    /**
     * 封面图片
     */
    private String coverPic;
}
