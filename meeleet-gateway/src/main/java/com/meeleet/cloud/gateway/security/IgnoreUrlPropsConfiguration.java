package com.meeleet.cloud.gateway.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 忽略URL属性配置
 *
 * @author pangu
 */
@Data
@RefreshScope
@ConfigurationProperties(prefix = "security.ignore")
@Component
public class IgnoreUrlPropsConfiguration {

    /**
     * 认证中心默认忽略验证地址
     */
    private static final String[] SECURITY_ENDPOINTS = {
            /** 图片验证码 */
            "/captcha",
            /** Other Service Swagger */
            "/*/webjars/**",
            "/*/swagger-resources/**",
            "/*/swagger-ui/**",
            "/*/v3/api-docs",
            /** Gateway Swagger*/
            "/webjars/**",
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/swagger-ui.html"
    };

    private List<String> urls = new ArrayList<>();

    /**
     * 首次加载合并ENDPOINTS
     */
    @PostConstruct
    public void initIgnoreSecurity() {
        Collections.addAll(urls,SECURITY_ENDPOINTS);
    }
}
