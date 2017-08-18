package com.bj.springboot.dao;

import com.bj.springboot.domain.User;

/**
 * Created by sunboyu on 2017/8/17.
 */
public interface UserDao {

    void save(User user);

    User findUserByUserName(String userName);

    void update(User user);

    void delete(Long id);
}
