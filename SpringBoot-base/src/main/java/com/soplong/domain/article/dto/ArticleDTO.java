package com.soplong.domain.article.dto;

import com.soplong.domain.article.ArticleInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ArticleDTO extends ArticleInfo implements Serializable {
    private String content;

    private Boolean postFlag;

    private List<Integer> tags;
}
