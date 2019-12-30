package com.soplong.dao.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soplong.domain.sys.Attachment;
import org.apache.ibatis.annotations.Param;

public interface AttachmentMapper extends BaseMapper<Attachment> {
    void editCorrelationId(@Param(value = "uuid") String uuid, @Param(value = "correlationId") Integer correlationId);

    void delFile(String uuid);
}
