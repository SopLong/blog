package com.soplong.controller.sys;

import com.soplong.config.ResultData;
import com.soplong.domain.user.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sys")
public class LoginController {


    @PostMapping("login")
    public ResultData login(@RequestBody User user){
        //获取当前登录人的主体信息
        Subject subject = SecurityUtils.getSubject();

        Object obj = new SimpleHash("MD5", user.getPassword(),"", 1024);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getName(),
                obj.toString()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return new ResultData("账号或密码错误！");
        } catch (AuthorizationException e) {
            e.printStackTrace();
            return new ResultData("没有权限");
        }
        return new ResultData();
    }
}
