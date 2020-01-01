package com.soplong.dao.article;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soplong.domain.article.ArticleInfo;
import com.soplong.domain.article.vo.ArticleDetailVO;
import com.soplong.domain.article.vo.ArticleListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ArticleInfoMapper extends BaseMapper<ArticleInfo> {
    List<ArticleInfo> articleList(Map<String, Object> reqMap, Page page);

    ArticleDetailVO getArticleDetail(int articleId);

    List<ArticleInfo> getBackArticle(Page page,@Param(value = "map") Map<String, String> reqMap);

    ArticleDetailVO articleBackDetail(int articleId);

    List<ArticleListVO> archiveTimeLine(Map<String, Object> reqMap);
}
