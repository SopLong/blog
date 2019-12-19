package com.soplong.controller.article;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soplong.config.BaseController;
import com.soplong.config.ResultData;
import com.soplong.domain.article.vo.ArticleDetailVO;
import com.soplong.service.article.ArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article/info")
public class ArticleInfoController extends BaseController {

    @Autowired
    private ArticleInfoService articleInfoService;

    /**
     * 获取博文列表
     *
     * @return
     */
    @GetMapping("getArticleList")
    public ResultData getArticle() {
        Map<String, Object> reqMap = getRequestParams();
        Page articleList = articleInfoService.articleList(reqMap, getPage());
        return new ResultData(articleList);
    }

    /**
     * 获取博客详情
     *
     * @param articleId 博客ID
     * @return
     */
    @GetMapping("articleDetail/{articleId}")
    public ResultData articleDetail(@PathVariable int articleId) {
        ArticleDetailVO articleDetail = articleInfoService.getArticleDetail(articleId);
        return new ResultData(articleDetail);
    }

    /**
     * 新建博文
     * @param articleDetailVO
     * @return
     */
    @PostMapping("add")
    public ResultData addArticle(@RequestBody ArticleDetailVO articleDetailVO){
        articleInfoService.addArticle(articleDetailVO);
        return new ResultData();
    }
}
