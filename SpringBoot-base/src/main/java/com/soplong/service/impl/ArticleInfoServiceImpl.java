package com.soplong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soplong.dao.ArticleInfoMapper;
import com.soplong.domain.ArticleInfo;
import com.soplong.service.ArticleInfoService;
import org.springframework.stereotype.Service;

@Service
public class ArticleInfoServiceImpl extends ServiceImpl<ArticleInfoMapper, ArticleInfo> implements ArticleInfoService {
}
