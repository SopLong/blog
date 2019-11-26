package com.soplong.config;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    public void packParams(){
        String pageNum = request.getParameter("pageNum");
        System.out.println(pageNum);
    }
}
