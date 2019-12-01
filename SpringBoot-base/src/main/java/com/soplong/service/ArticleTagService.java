package com.soplong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soplong.domain.ArticleTag;

public interface ArticleTagService extends IService<ArticleTag> {
    /**
     * 新增标签
     * @param articleTag
     */
    void add(ArticleTag articleTag);

    /**
     * 删除标签
     * @param tagId
     */
    void delTag(int tagId);
}
