package com.soplong.config.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.soplong.domain.user.User;
import com.soplong.service.user.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

// 实现AuthorizingRealm接口 用于登录授权
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //角色权限和对应权限添加
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
//        if (authenticationToken.getPrincipal() == null) {
//            return null;
//        }


        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //获取用户信息
        User user = userService.getOne(new QueryWrapper<User>().eq("name", token.getUsername()).eq("is_effective", 1));
        if (user == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
//            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes("Mark"), getName());
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
            return simpleAuthenticationInfo;
        }
    }
}
