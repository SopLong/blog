package com.soplong.dao.article;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soplong.domain.article.ArticleContent;

public interface ArticleContentMapper extends BaseMapper<ArticleContent> {

    void delContent(Integer id);
}
