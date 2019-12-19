package com.soplong.dao.article;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soplong.domain.article.ArticleInfo;
import com.soplong.domain.article.vo.ArticleDetailVO;

import java.util.List;
import java.util.Map;

public interface ArticleInfoMapper extends BaseMapper<ArticleInfo> {
    List<ArticleInfo> articleList(Map<String, Object> reqMap, Page page);

    ArticleDetailVO getArticleDetail(int articleId);
}
