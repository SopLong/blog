package com.soplong.service.article.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soplong.dao.article.ArticleTagMapper;
import com.soplong.domain.article.ArticleTag;
import com.soplong.service.article.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements ArticleTagService {

    @Autowired
    private ArticleTagMapper articleTagMapper;

    @Override
    public void delTags(Integer id) {
        articleTagMapper.delTags(id);
    }
}
