package com.meeleet.mall.ums;

import com.meeleet.cloud.mybatis.handler.MyMetaObjectHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@Import({com.meeleet.cloud.common.mybatis.config.MybatisPlusConfig.class, MyMetaObjectHandler.class})
@SpringBootApplication
@EnableDiscoveryClient
public class MallUmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallUmsApplication.class, args);
    }
}
