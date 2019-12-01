package com.soplong.controller;

import com.soplong.config.BaseController;
import com.soplong.config.ResultData;
import com.soplong.domain.ArticleTag;
import com.soplong.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article/tag")
public class ArticleTagController extends BaseController {

    @Autowired
    private ArticleTagService articleTagServicel;

    /**
     * 新增标签
     * @param name
     * @return
     */
    @PostMapping("add")
    public ResultData addTag(@RequestBody ArticleTag articleTag){
        articleTagServicel.add(articleTag);
        return new ResultData();
    }

    /**
     * 删除标签
     * @param tagId
     * @return
     */
    @DeleteMapping("del/{tagId}")
    public ResultData delTag(@PathVariable int tagId){
        articleTagServicel.delTag(tagId);
        return new ResultData();
    }
}
