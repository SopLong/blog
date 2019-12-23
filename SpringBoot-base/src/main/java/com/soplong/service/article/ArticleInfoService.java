package com.soplong.service.article;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.soplong.domain.article.ArticleInfo;
import com.soplong.domain.article.vo.ArticleDetailVO;

import java.util.Map;

public interface ArticleInfoService extends IService<ArticleInfo> {
    /**
     * 获取博文列表(前端)
     * @param reqMap
     * @param page
     * @return
     */
    Page articleList(Map<String, Object> reqMap, Page page);

    /**
     * 获取博客详情
     * @param articleId
     * @return
     */
    ArticleDetailVO getArticleDetail(int articleId);

    /**
     * 新建博文
     * @param articleDetailVO
     */
    void addArticle(ArticleDetailVO articleDetailVO);

    /**
     * 获取博文列表(后端)
     * @param reqMap
     * @param page
     * @return
     */
    Page getBackArticle(Map<String, String> reqMap, Page page);
}
