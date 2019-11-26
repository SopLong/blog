package com.soplong.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soplong.config.BaseController;
import com.soplong.config.ResultData;
import com.soplong.domain.ArticleInfo;
import com.soplong.service.ArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article/info")
public class ArticleInfoController extends BaseController {

    @Autowired
    private ArticleInfoService articleInfoService;

    @GetMapping("getArticleList")
    public ResultData getArticle(@RequestParam int pageNum, @RequestParam int pageSize) {

        packParams();

        Page page = new Page();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage pa = articleInfoService.page(page, new QueryWrapper<ArticleInfo>().eq("del_flag", 0));

        return new ResultData(pa.getRecords());
    }
}
