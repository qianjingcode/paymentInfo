package com.iris;

import com.iris.common.utils.SpringContextUtil;
import com.iris.springboot.starter.mybatis.EnableIrisMybatis;
import com.iris.springboot.starter.redis.EnableIrisRedis;
import com.iris.springboot.starter.web.EnableIrisWeb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

/**
 * @author qianjing
 * @date 2020-06-08
 */
@SpringBootApplication
@EnableIrisWeb
@EnableIrisRedis
@EnableIrisMybatis
@EnableFeignClients(basePackages = "com.iris.api")
public class PaymentApplication {

    /**
     * 日志类
     */
    protected static final Logger logger = LoggerFactory.getLogger(PaymentApplication.class);



    /**
     * main
     *
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(PaymentApplication.class, args);
        SpringContextUtil.setApplicationContext(app);
    }

}
