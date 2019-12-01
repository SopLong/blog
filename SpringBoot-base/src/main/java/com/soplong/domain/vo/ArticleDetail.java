package com.soplong.domain.vo;

import com.soplong.domain.ArticleInfo;
import lombok.Data;

@Data
public class ArticleDetail extends ArticleInfo {

    /**
     * 博客内容
     */
    private String Content;
}
