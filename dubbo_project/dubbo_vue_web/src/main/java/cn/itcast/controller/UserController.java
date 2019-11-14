package cn.itcast.controller;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Reference(check = false,loadbalance = "random")//从注册中心中找寻对应的对象类型
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll() throws Exception {

        return userService.findAll();

    }

    @RequestMapping("/findById")
    public User findById(String ids){

        return userService.findById(ids);
    }

}
