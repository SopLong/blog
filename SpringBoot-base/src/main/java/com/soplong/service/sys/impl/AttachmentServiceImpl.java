package com.soplong.service.sys.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soplong.dao.sys.AttachmentMapper;
import com.soplong.domain.sys.Attachment;
import com.soplong.exception.CustomException;
import com.soplong.service.sys.AttachmentService;
import com.soplong.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class AttachmentServiceImpl extends ServiceImpl<AttachmentMapper, Attachment> implements AttachmentService {

    @Value("${base_attachment_filePath}")
    private String FILE_PHTN;
    @Value("${base_attachment_httpPath}")
    private String HTTP_PATH;
    @Value("${base_attachment_separator}")
    private String SEPARATOR;
    @Autowired
    private AttachmentMapper attachmentMapper;

    @Override
    public Attachment upload(MultipartHttpServletRequest multiReq, Map<String, Object> reqMap) {
        Map<String, MultipartFile> fileMap = multiReq.getFileMap();
        Map.Entry<String, MultipartFile> entry = fileMap.entrySet().iterator().next();
        MultipartFile file = fileMap.get(entry.getKey());
        try {
            String fileName = file.getOriginalFilename();
            String newFileName = UUID.randomUUID().toString() + "_" + fileName;
            String currentDate = DateUtils.getCurrentDate();
            String filePath = FILE_PHTN + "/" + currentDate + "/" + newFileName;
            String httpPath = HTTP_PATH + "/" + currentDate + "/" + newFileName;
            String fileType = fileName.substring(fileName.lastIndexOf("."));
            File dest = new File(FILE_PHTN + SEPARATOR + currentDate + SEPARATOR + newFileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            file.transferTo(dest);

            //插入附件记录
            Attachment attachment = new Attachment();
            attachment.setUuid(UUID.randomUUID().toString());
            attachment.setFileName(fileName);
            attachment.setFilePath(filePath);
            attachment.setHttpPath(httpPath);
            attachment.setFileType(fileType);
            attachment.setType(reqMap.get("type").toString());
            this.save(attachment);
            return attachment;
        } catch (Exception e) {
            log.error("上传附件失败:", e);
            throw new CustomException("上传失败!");
        }
    }

    @Override
    public void editCorrelationId(String uuid, Integer correlationId) {
        attachmentMapper.editCorrelationId(uuid,correlationId);
    }

    @Override
    public void delFile(String uuid) {
        attachmentMapper.delFile(uuid);
    }
}
