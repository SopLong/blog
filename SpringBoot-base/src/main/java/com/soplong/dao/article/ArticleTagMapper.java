package com.soplong.dao.article;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soplong.domain.article.ArticleTag;

public interface ArticleTagMapper extends BaseMapper<ArticleTag> {
    void delTags(Integer id);
}
