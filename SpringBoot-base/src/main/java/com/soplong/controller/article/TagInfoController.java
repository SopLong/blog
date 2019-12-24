package com.soplong.controller.article;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.soplong.config.BaseController;
import com.soplong.config.ResultData;
import com.soplong.domain.article.TagInfo;
import com.soplong.exception.CustomException;
import com.soplong.service.article.TagInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article/tag")
public class TagInfoController extends BaseController {

    @Autowired
    private TagInfoService articleTagService;

    /**
     * 新增标签
     *
     * @param articleTag
     * @return
     */
    @PostMapping("add")
    public ResultData addTag(@RequestBody TagInfo articleTag) {
        TagInfo tag = articleTagService.getOne(new QueryWrapper<TagInfo>().eq("tag_name", articleTag.getTagName()).eq("del_flag", 0));
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
        List<TagInfo> articleTag = articleTagService.list(new QueryWrapper<TagInfo>().eq("del_flag", 0));
        return new ResultData(articleTag);
    }
}
