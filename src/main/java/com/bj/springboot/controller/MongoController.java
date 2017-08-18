package com.bj.springboot.controller;

import com.bj.springboot.dao.UserDao;
import com.bj.springboot.domain.User;
import com.bj.springboot.domain.mongo.PrimaryMongoObject;
import com.bj.springboot.domain.mongo.SecondMongoObject;
import com.bj.springboot.repository.mongo.primary.PrimaryRepository;
import com.bj.springboot.repository.mongo.secondary.SecondRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by sunboyu on 2017/8/17.
 */
@RestController
@RequestMapping("/mongo")
@Slf4j
public class MongoController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PrimaryRepository primaryRepository;

    @Autowired
    private SecondRepository secondRepository;

    @RequestMapping("/saveAll")
    public void saveAll() {

        log.info("************************************************************");
        log.info("测试开始");
        log.info("************************************************************");

        this.primaryRepository
                .save(new PrimaryMongoObject(null, "第一个库的对象"));

        this.secondRepository
                .save(new SecondMongoObject(null, "第二个库的对象"));

        List<PrimaryMongoObject> primaries = this.primaryRepository.findAll();
        for (PrimaryMongoObject primary : primaries) {
            log.info(primary.toString());
        }

        List<SecondMongoObject> secondaries = this.secondRepository.findAll();

        for (SecondMongoObject secondary : secondaries) {
            log.info(secondary.toString());
        }

        log.info("************************************************************");
        log.info("测试完成");
        log.info("************************************************************");
    }

    @RequestMapping("/save")
    public void save() {
        User user = new User();
        user.setId(new Random().nextLong());
        user.setUsername("小明" + new Random().nextInt());
        user.setPassword(UUID.randomUUID().toString());
        userDao.save(user);
    }

    @RequestMapping("/findByName")
    public User findByUsername() {
        return userDao.findUserByUserName("小明");
    }

    @RequestMapping("/update")
    public void update() {
        User user = new User();
        user.setId(2167834606165635590l);
        user.setUsername("天空");
        user.setPassword("fffxxxx");
        userDao.update(user);
    }

    @RequestMapping("/delete")
    public void delete() {
        Long id = -2425841582064392792l;
        userDao.delete(id);
    }
}
