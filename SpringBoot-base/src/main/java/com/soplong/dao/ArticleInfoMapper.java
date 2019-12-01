package com.soplong.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soplong.domain.ArticleInfo;
import com.soplong.domain.vo.ArticleDetail;

import java.util.List;
import java.util.Map;

public interface ArticleInfoMapper extends BaseMapper<ArticleInfo> {
    List<ArticleInfo> articleList(Map<String, Object> reqMap, Page page);

    ArticleDetail getArticleDetail(int articleId);
}
