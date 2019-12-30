package com.soplong.domain.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Attachment implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文件唯一标识ID
     */
    private String uuid;

    /**
     * 关联标识
     */
    private String correlationId;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 文件http路径
     */
    private String httpPath;

    /**
     * 上传时间
     */
    private Date uploadTime;

    /**
     * 上传人
     */
    private String uploadUser;

    /**
     * 【0】正常 【1】删除
     */
    private Integer delFlag;

    /**
     * 删除时间
     */
    private Date delTime;

    /**
     * 业务类型
     */
    private String type;
}
