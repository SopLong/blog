package com.soplong.controller.article;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.soplong.config.BaseController;
import com.soplong.config.ResultData;
import com.soplong.domain.article.ArticleTag;
import com.soplong.exception.CustomException;
import com.soplong.service.article.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article/tag")
public class ArticleTagController extends BaseController {

    @Autowired
    private ArticleTagService articleTagService;

    /**
     * 新增标签
     *
     * @param name
     * @return
     */
    @PostMapping("add")
    public ResultData addTag(@RequestBody ArticleTag articleTag) {
        ArticleTag tag = articleTagService.getOne(new QueryWrapper<ArticleTag>().eq("tag_name", articleTag.getTagName()).eq("del_flag", 0));
        if (null != tag) {
            throw new CustomException("标签【" + articleTag.getTagName() + "】已存在!");
        }
        articleTagService.addTag(articleTag);
        return new ResultData();
    }

    /**
     * 删除标签
     *
     * @param tagId
     * @return
     */
    @DeleteMapping("del/{tagId}")
    public ResultData delTag(@PathVariable int tagId) {
        articleTagService.delTag(tagId);
        return new ResultData();
    }

    /**
     * 获取标签
     *
     * @return
     */
    @GetMapping("getTagAll")
    public ResultData getTagAll() {
        List<ArticleTag> articleTag = articleTagService.list(new QueryWrapper<ArticleTag>().eq("del_flag", 0));
        return new ResultData(articleTag);
    }
}
