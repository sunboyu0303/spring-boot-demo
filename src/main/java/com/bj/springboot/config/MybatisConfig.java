package com.bj.springboot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sunboyu on 2017/8/10.
 */
@Configuration
@MapperScan("com.bj.springboot.mapper")
public class MybatisConfig {
}
