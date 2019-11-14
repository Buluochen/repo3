package cn.itcast.service;

import cn.itcast.domain.User;
import cn.itcast.mapper.UserMapper;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//将UserServiceImpl 发布到注册中心（暴露服务）
@Service(interfaceClass = UserService.class,loadbalance = "random")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    public List<User> findAll() throws Exception {
        return userMapper.findAll();
    }

    public User findById(String id) {
        return userMapper.findById(id);
    }
}
