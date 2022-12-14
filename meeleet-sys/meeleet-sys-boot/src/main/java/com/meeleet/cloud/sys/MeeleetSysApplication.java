package com.meeleet.cloud.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@Import({ com.meeleet.cloud.common.redis.RedisConfig.class})
@SpringBootApplication
@EnableDiscoveryClient
public class MeeleetSysApplication {
    public static void main(String[] args) {
        SpringApplication.run(MeeleetSysApplication.class, args);
    }
}
