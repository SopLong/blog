package com.soplong.service.article.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soplong.dao.article.ArticleContentMapper;
import com.soplong.domain.article.ArticleContent;
import com.soplong.service.article.ArticleContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleContentServiceImpl extends ServiceImpl<ArticleContentMapper, ArticleContent> implements ArticleContentService {

    @Autowired
    private ArticleContentMapper articleContentMapper;

    @Override
    public void delContent(Integer id) {
        articleContentMapper.delContent(id);
    }
}
