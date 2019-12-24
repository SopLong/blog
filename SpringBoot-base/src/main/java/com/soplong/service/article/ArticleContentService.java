package com.soplong.service.article;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soplong.domain.article.ArticleContent;

public interface ArticleContentService extends IService<ArticleContent> {
    /**
     * 删除博文内容
     * @param id
     */
    void delContent(Integer id);
}
