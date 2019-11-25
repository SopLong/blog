package com.soplong.controller;

import com.soplong.domain.ArticleInfo;
import com.soplong.service.ArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("article/info")
public class ArticleInfoController {

    @Autowired
    private ArticleInfoService articleInfoService;

    @GetMapping("getArticleList")
    public void getArticle(@RequestParam int pageNum, @RequestParam int pageSize){
    }
}
