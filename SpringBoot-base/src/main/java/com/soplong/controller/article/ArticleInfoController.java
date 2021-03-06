package com.soplong.controller.article;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soplong.config.BaseController;
import com.soplong.config.ResultData;
import com.soplong.domain.article.ArticleInfo;
import com.soplong.domain.article.dto.ArticleDTO;
import com.soplong.domain.article.vo.ArticleDetailVO;
import com.soplong.domain.article.vo.ArticleListVO;
import com.soplong.exception.CustomException;
import com.soplong.service.article.ArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article/info")
public class ArticleInfoController extends BaseController {

    @Autowired
    private ArticleInfoService articleInfoService;

    /**
     * 获取博文列表(前端)
     *
     * @return
     */
    @GetMapping("front/getArticleList")
    public ResultData getArticle() {
        Map<String, Object> reqMap = getRequestParams();
        Page articleList = articleInfoService.articleList(reqMap, getPage());
        return new ResultData(articleList);
    }

    /**
     * 获取博文列表(后端)
     *
     * @return
     */
    @GetMapping("back/getBackArticle")
    public ResultData getBackArticle() {
        Map<String, String> reqMap = getRequestParamsStr();
        Page articleList = articleInfoService.getBackArticle(reqMap, getPage());
        return new ResultData(articleList);
    }

    /**
     * 获取博客详情
     *
     * @param articleId 博客ID
     * @return
     */
    @GetMapping("front/articleDetail/{articleId}")
    public ResultData articleDetail(@PathVariable int articleId) {
        ArticleDetailVO articleDetail = articleInfoService.getArticleDetail(articleId);
        return new ResultData(articleDetail);
    }

    /**
     * 获取博客详情
     *
     * @param articleId 博客ID
     * @return
     */
    @GetMapping("back/articleDetail/{articleId}")
    public ResultData articleBackDetail(@PathVariable int articleId) {
        ArticleDetailVO articleDetail = articleInfoService.articleBackDetail(articleId);
        return new ResultData(articleDetail);
    }

    /**
     * 新建博文
     *
     * @param articleDTO
     * @return
     */
    @PostMapping("add")
    public ResultData addArticle(@RequestBody ArticleDTO articleDTO) {
        articleInfoService.addArticle(articleDTO);
        return new ResultData();
    }

    /**
     * 编辑博文
     * @param articleDTO
     * @return
     */
    @PutMapping("edit")
    public ResultData editArticle(@RequestBody ArticleDTO articleDTO){
        articleInfoService.editArticle(articleDTO);
        return new ResultData();
    }

    /**
     * 删除博文
     *
     * @param id
     * @return
     */
    @DeleteMapping("back/delArticle/{id}")
    public ResultData delArticle(@PathVariable int id) {
        ArticleInfo articleInfo = articleInfoService.getById(id);
        if (null == articleInfo) {
            throw new CustomException("博文不存在!");
        }
        articleInfo.setDelFlag(1);
        articleInfoService.updateById(articleInfo);
        return new ResultData();
    }

    /**
     * 归档时间线数据
     * @return
     */
    @GetMapping("archiveTimeLine")
    public ResultData archiveTimeLine(){
        Map<String, Object> reqMap = getRequestParams();
        List<ArticleListVO> articleListVOS = articleInfoService.archiveTimeLine(reqMap);
        return new ResultData(articleListVOS);
    }
}
