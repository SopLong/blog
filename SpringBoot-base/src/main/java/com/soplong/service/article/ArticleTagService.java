package com.soplong.service.article;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soplong.domain.article.ArticleTag;

public interface ArticleTagService extends IService<ArticleTag> {
    /**
     * 新增标签
     * @param articleTag
     */
    void addTag(ArticleTag articleTag);

    /**
     * 删除标签
     * @param tagId
     */
    void delTag(int tagId);
}
