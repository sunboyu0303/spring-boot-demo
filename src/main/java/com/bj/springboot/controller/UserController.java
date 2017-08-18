package com.bj.springboot.controller;

import com.bj.springboot.domain.User;
import com.bj.springboot.mapper.UserMapper;
import com.bj.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sunboyu on 2017/8/7.
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/save")
    public User save(@RequestParam String userName, @RequestParam String password){

        log.info("UserController[save]: username {}, password {} ", userName, password);
        User u = new User();
        u.setUsername(userName);
        u.setPassword(password);
        return userService.save(u);
    }

    @RequestMapping("/find/{id}")
    public User find(@PathVariable Long id){
        return userMapper.getOne(id);
    }

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userMapper.getAll();
    }

    @RequestMapping("/insert/{userName}/{password}")
    public String insert(@PathVariable String userName, @PathVariable String password){

        User u = new User();
        u.setUsername(userName);
        u.setPassword(password);

        userMapper.insert(u);
        return "success";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        userMapper.delete(id);
        return "succsess";
    }
}