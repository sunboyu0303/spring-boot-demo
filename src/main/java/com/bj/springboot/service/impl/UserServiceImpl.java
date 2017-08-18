package com.bj.springboot.service.impl;

import com.bj.springboot.domain.User;
import com.bj.springboot.repository.UserRepository;
import com.bj.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sunboyu on 2017/8/7.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User u) {
        return userRepository.save(u);
    }
}
