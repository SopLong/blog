package com.soplong.service.article;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soplong.domain.article.ArticleTag;

public interface ArticleTagService extends IService<ArticleTag> {
    /**
     * 删除标签信息
     * @param id
     */
    void delTags(Integer id);
}
