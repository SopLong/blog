package com.soplong.domain.article.vo;

import com.soplong.domain.article.ArticleInfo;
import lombok.Data;

import java.util.List;

@Data
public class ArticleDetailVO extends ArticleInfo {

    /**
     * 博客内容
     */
    private String content;

    /**
     * 标签
     */
    private List<Integer> tags;

    /**
     * 是否发布
     */
    private boolean postFlag;

    public boolean isPostFlag() {
        if(super.getIsPost() == 0){
            return false;
        }
        return true;
    }
}
