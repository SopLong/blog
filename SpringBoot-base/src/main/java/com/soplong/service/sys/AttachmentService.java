package com.soplong.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soplong.domain.sys.Attachment;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;

public interface AttachmentService extends IService<Attachment> {
    /**
     * 上传附件
     * @param multiReq
     * @param reqMap
     * @return
     */
    Attachment upload(MultipartHttpServletRequest multiReq, Map<String,Object> reqMap);

    /**
     * 保存附件关联ID
     * @param uuid
     * @param correlationId
     */
    void editCorrelationId(String uuid, Integer correlationId);

    /**
     * 删除附件信息
     * @param uuid
     */
    void delFile(String uuid);
}
