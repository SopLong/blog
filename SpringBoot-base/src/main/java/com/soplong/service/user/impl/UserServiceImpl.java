package com.soplong.service.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soplong.dao.user.UserMapper;
import com.soplong.domain.user.User;
import com.soplong.service.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
