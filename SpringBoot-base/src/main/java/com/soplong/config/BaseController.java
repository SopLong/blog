package com.soplong.config;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    public Map<String, Object> getRequestParams() {
        Map<String, Object> map = new HashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        if (null != parameterNames) {
            while (parameterNames.hasMoreElements()) {
                String key = parameterNames.nextElement();
                String value = request.getParameter(key);
                map.put(key, value);
            }
        }
        return map;
    }

    public Page getPage() {
        Page page = new Page();
        page.setCurrent(Long.parseLong(request.getParameter("currentPage")));
        page.setSize(Long.parseLong(request.getParameter("pageSize")));
        return page;
    }
}
