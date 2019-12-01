package com.soplong.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soplong.dao.ArticleInfoMapper;
import com.soplong.domain.ArticleInfo;
import com.soplong.domain.vo.ArticleDetail;
import com.soplong.service.ArticleInfoService;
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
    public ArticleDetail getArticleDetail(int articleId) {
        return articleInfoMapper.getArticleDetail(articleId);
    }
}
