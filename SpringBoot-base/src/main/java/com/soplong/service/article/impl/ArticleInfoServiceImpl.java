package com.soplong.service.article.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soplong.config.constant.AttachmentType;
import com.soplong.dao.article.ArticleInfoMapper;
import com.soplong.domain.article.ArticleContent;
import com.soplong.domain.article.ArticleInfo;
import com.soplong.domain.article.ArticleTag;
import com.soplong.domain.article.dto.ArticleDTO;
import com.soplong.domain.article.vo.ArticleDetailVO;
import com.soplong.domain.article.vo.ArticleListVO;
import com.soplong.domain.sys.Attachment;
import com.soplong.exception.CustomException;
import com.soplong.service.article.ArticleContentService;
import com.soplong.service.article.ArticleInfoService;
import com.soplong.service.article.ArticleTagService;
import com.soplong.service.sys.AttachmentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ArticleInfoServiceImpl extends ServiceImpl<ArticleInfoMapper, ArticleInfo> implements ArticleInfoService {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;
    @Autowired
    private ArticleTagService articleTagService;
    @Autowired
    private ArticleContentService articleContentService;
    @Autowired
    private AttachmentService attachmentService;

    @Override
    public Page articleList(Map<String, Object> reqMap, Page page) {
        page.setRecords(articleInfoMapper.articleList(reqMap, page));
        return page;
    }

    @Override
    public ArticleDetailVO getArticleDetail(int articleId) {
        ArticleDetailVO articleDetail = articleInfoMapper.getArticleDetail(articleId);
        Attachment file = attachmentService.getOne(new QueryWrapper<Attachment>().eq("del_flag", 0).eq("type", AttachmentType.ARTICLE_COVER.getType()).eq("correlation_id", articleId));
        articleDetail.setFile(file);
        return articleDetail;
    }

    @Override
    public void addArticle(ArticleDTO articleDTO) {
        ArticleInfo articleInfo = new ArticleInfo();
        try {
            BeanUtils.copyProperties(articleDTO, articleInfo);
            articleInfo.setIsPost(articleDTO.getPostFlag() ? 1 : 0);
            if (articleDTO.getPostFlag()) {
                articleInfo.setPostTime(new Date());
            }
            this.save(articleInfo);

            ArticleContent articleContent = new ArticleContent();
            articleContent.setArticleId(articleInfo.getId());
            articleContent.setContent(articleDTO.getContent());
            articleContent.setMdContent(articleDTO.getMdContent());
            articleContentService.save(articleContent);

            List<Integer> tags = articleDTO.getTags();
            if (null != tags && !tags.isEmpty()) {
                for (Integer tagId : tags) {
                    ArticleTag articleTag = new ArticleTag();
                    articleTag.setTagId(tagId);
                    articleTag.setArticleId(articleInfo.getId());
                    articleTagService.save(articleTag);
                }
            }
            if(StringUtils.isNotBlank(articleDTO.getUuid())){
                attachmentService.editCorrelationId(articleDTO.getUuid(),articleInfo.getId());
            }
        } catch (Exception e) {
            log.error("新建博文失败:", e);
            throw new CustomException("保存失败!");
        }
    }

    @Override
    public Page getBackArticle(Map<String, String> reqMap, Page page) {
        page.setRecords(articleInfoMapper.getBackArticle(page, reqMap));
        return page;
    }

    @Override
    public ArticleDetailVO articleBackDetail(int articleId) {
        ArticleDetailVO articleDetailVO = articleInfoMapper.articleBackDetail(articleId);
        Attachment file = attachmentService.getOne(new QueryWrapper<Attachment>().eq("del_flag", 0).eq("type", AttachmentType.ARTICLE_COVER.getType()).eq("correlation_id", articleId));
        List<ArticleTag> tags = articleTagService.list(new QueryWrapper<ArticleTag>().eq("article_id", articleId).eq("del_flag", 0));
        if(null != tags && !tags.isEmpty()){
            List<Integer> tagIds = tags.stream().map(ArticleTag::getTagId).distinct().collect(Collectors.toList());
            articleDetailVO.setTags(tagIds);
        }
        articleDetailVO.setFile(file);
        return articleDetailVO;
    }

    @Override
    public void editArticle(ArticleDTO articleDTO) {
        ArticleInfo articleInfo = this.getById(articleDTO.getId());
        if(null == articleDTO){
            throw new CustomException("该博文不存在!");
        }
        try {
            articleInfo.setTitle(articleDTO.getTitle());
            articleInfo.setSummary(articleDTO.getSummary());
            articleInfo.setIsPost(articleDTO.getPostFlag() ? 1 : 0);
            if (articleDTO.getPostFlag()) {
                articleInfo.setPostTime(new Date());
            }
            this.updateById(articleInfo);

            //删除原有的博文内容
            articleContentService.delContent(articleInfo.getId());
            ArticleContent articleContent = new ArticleContent();
            articleContent.setArticleId(articleInfo.getId());
            articleContent.setContent(articleDTO.getContent());
            articleContentService.save(articleContent);

            List<Integer> tags = articleDTO.getTags();
            if (null != tags && !tags.isEmpty()) {
                //删除原有的标签信息
                articleTagService.delTags(articleInfo.getId());
                for (Integer tagId : tags) {
                    ArticleTag articleTag = new ArticleTag();
                    articleTag.setTagId(tagId);
                    articleTag.setArticleId(articleInfo.getId());
                    articleTagService.save(articleTag);
                }
            }

            if(StringUtils.isNotBlank(articleDTO.getUuid())){
                attachmentService.editCorrelationId(articleDTO.getUuid(),articleInfo.getId());
            }
        } catch (Exception e) {
            log.error("新建博文失败:", e);
            throw new CustomException("保存失败!");
        }
    }

    @Override
    public List<ArticleListVO> archiveTimeLine(Map<String, Object> reqMap) {
        return articleInfoMapper.archiveTimeLine(reqMap);
    }
}
