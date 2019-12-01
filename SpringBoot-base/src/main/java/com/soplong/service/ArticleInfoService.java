package com.soplong.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.soplong.domain.ArticleInfo;
import com.soplong.domain.vo.ArticleDetail;

import java.util.Map;

public interface ArticleInfoService extends IService<ArticleInfo> {
    //获取博文列表
    Page articleList(Map<String, Object> reqMap, Page page);

    /**
     * 获取博客详情
     * @param articleId
     * @return
     */
    ArticleDetail getArticleDetail(int articleId);
}
