package com.soplong.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soplong.dao.ArticleTagMapper;
import com.soplong.domain.ArticleTag;
import com.soplong.exception.CustomException;
import com.soplong.service.ArticleTagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements ArticleTagService {

    @Override
    @Transactional
    public void add(ArticleTag articleTag) {
        try {
            this.add(articleTag);
        } catch (Exception e) {
            throw new CustomException("保存失败!");
        }
    }

    @Override
    public void delTag(int tagId) {
        ArticleTag tag = this.getOne(new QueryWrapper<ArticleTag>().eq("id", tagId).eq("del_flag", 0));
        if (null == tag) {
            throw new CustomException("该标签不存在!");
        }
        tag.setDelFlag(1);
        this.updateById(tag);
    }
}
