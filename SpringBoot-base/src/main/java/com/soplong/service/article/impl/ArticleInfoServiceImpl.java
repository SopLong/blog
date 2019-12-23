package com.soplong.service.article.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soplong.dao.article.ArticleInfoMapper;
import com.soplong.domain.article.ArticleInfo;
import com.soplong.domain.article.vo.ArticleDetailVO;
import com.soplong.service.article.ArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ArticleInfoServiceImpl extends ServiceImpl<ArticleInfoMapper, ArticleInfo> implements ArticleInfoService {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Override
    public Page articleList(Map<String, Object> reqMap, Page page) {
        page.setRecords(articleInfoMapper.articleList(reqMap,page));
        return page;
    }

    @Override
    public ArticleDetailVO getArticleDetail(int articleId) {
        return articleInfoMapper.getArticleDetail(articleId);
    }

    @Override
    public void addArticle(ArticleDetailVO articleDetailVO) {

    }

    @Override
    public Page getBackArticle(Map<String, Object> reqMap, Page page) {
        page.setRecords(articleInfoMapper.getBackArticle(reqMap,page));
        return page;
    }
}
