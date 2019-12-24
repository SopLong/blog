package com.soplong.service.article;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soplong.domain.article.TagInfo;

public interface TagInfoService extends IService<TagInfo> {
    /**
     * 新增标签
     * @param articleTag
     */
    void addTag(TagInfo articleTag);

    /**
     * 删除标签
     * @param tagId
     */
    void delTag(int tagId);
}
