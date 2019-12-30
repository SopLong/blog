package com.soplong.controller.sys;

import com.soplong.config.BaseController;
import com.soplong.config.ResultData;
import com.soplong.service.sys.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;

@RestController
@RequestMapping("file")
public class FileController extends BaseController {

    @Autowired
    private AttachmentService attachmentService;

    @RequestMapping("upload")
    public ResultData upload(MultipartHttpServletRequest multiReq) {
        Map<String, Object> reqMap = getRequestParams();
        return new ResultData(attachmentService.upload(multiReq, reqMap));
    }

    @PutMapping("delFile/{uuid}")
    public ResultData delFile(@PathVariable String uuid) {
        attachmentService.delFile(uuid);
        return new ResultData();
    }
}
