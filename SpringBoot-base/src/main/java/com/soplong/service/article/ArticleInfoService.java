package com.soplong.service.article;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.soplong.domain.article.ArticleInfo;
import com.soplong.domain.article.dto.ArticleDTO;
import com.soplong.domain.article.vo.ArticleDetailVO;
import com.soplong.domain.article.vo.ArticleListVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
     * @param articleDTO
     */
    @Transactional(rollbackFor = Exception.class)
    void addArticle(ArticleDTO articleDTO);

    /**
     * 获取博文列表(后端)
     * @param reqMap
     * @param page
     * @return
     */
    Page getBackArticle(Map<String, String> reqMap, Page page);

    /**
     * 后端获取博文详情
     * @param articleId
     * @return
     */
    ArticleDetailVO articleBackDetail(int articleId);

    /**
     * 编辑博文
     * @param articleDTO
     */
    @Transactional(rollbackFor = Exception.class)
    void editArticle(ArticleDTO articleDTO);

    /**
     * 归档时间线数据
     * @param reqMap
     * @return
     */
    List<ArticleListVO> archiveTimeLine(Map<String, Object> reqMap);
}
