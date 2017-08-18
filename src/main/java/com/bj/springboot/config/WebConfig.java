package com.bj.springboot.config;

import com.bj.springboot.filter.MyFilter;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sunboyu on 2017/8/6.
 */
@Configuration
public class WebConfig {

    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){

        FilterRegistrationBean frb = new FilterRegistrationBean();
        frb.setFilter(new MyFilter());
        frb.addUrlPatterns("/*");
        frb.addInitParameter("paramName", "paramValue");
        frb.setName("MyFilter");
        frb.setOrder(1);
        return frb;
    }
}
