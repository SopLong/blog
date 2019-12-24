package com.soplong.service.article.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soplong.dao.article.TagInfoMapper;
import com.soplong.domain.article.TagInfo;
import com.soplong.exception.CustomException;
import com.soplong.service.article.TagInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TagInfoServiceImpl extends ServiceImpl<TagInfoMapper, TagInfo> implements TagInfoService {

    @Override
    @Transactional
    public void addTag(TagInfo articleTag) {
        try {
            this.save(articleTag);
        } catch (Exception e) {
            log.error("保存标签失败:{}",e);
            throw new CustomException("保存失败!");
        }
    }

    @Override
    public void delTag(int tagId) {
        TagInfo tag = this.getOne(new QueryWrapper<TagInfo>().eq("id", tagId).eq("del_flag", 0));
        if (null == tag) {
            throw new CustomException("该标签不存在!");
        }
        tag.setDelFlag(1);
        this.updateById(tag);
    }
}
