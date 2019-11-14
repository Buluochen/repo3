package cn.itcast.service;


import cn.itcast.domain.User;

import java.util.List;

public interface UserService {
    //查询所有用户信息
    List<User> findAll() throws Exception;

    User findById(String id);
}
