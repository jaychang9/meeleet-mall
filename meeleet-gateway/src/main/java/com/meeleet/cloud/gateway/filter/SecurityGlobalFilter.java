package com.meeleet.cloud.gateway.filter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.meeleet.cloud.common.constant.GlobalConstants;
import com.meeleet.cloud.common.result.ResultCode;
import com.meeleet.cloud.common.security.constant.SecurityConstants;
import com.meeleet.cloud.gateway.util.ResponseUtils;
import com.nimbusds.jose.JWSObject;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;

/**
 * 安全拦截全局过滤器，非网关鉴权的逻辑
 * <p>
 * 在ResourceServerManager#check鉴权善后一些无关紧要的事宜(线上请求拦截、黑名单拦截)
 *
 * @author jaychang
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class SecurityGlobalFilter implements GlobalFilter, Ordered {

    private final RedisTemplate redisTemplate;

    @Value("${spring.profiles.active:default}")
    private String env;

    @SneakyThrows
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        // 拦截线上禁止的操作
        if (isForbiddenRequest(request)) {
            return ResponseUtils.writeErrorInfo(response, ResultCode.FORBIDDEN_OPERATION);
        }

        // 拦截黑名单JWT
        String authorization = request.getHeaders().getFirst(SecurityConstants.AUTHORIZATION_KEY);
        if (StrUtil.isBlank(authorization)) {
            return chain.filter(exchange);
        }
        String payload = this.getPayload(authorization);
        if (StrUtil.isBlank(payload)) {
            return chain.filter(exchange);
        }

        // 解析JWT获取jti，以jti为key判断redis的黑名单列表是否存在，存在则拦截访问
        JSONObject jsonObject = JSONUtil.parseObj(payload);
        String jti = jsonObject.getStr(SecurityConstants.JWT_JTI);
        Boolean isBlack = redisTemplate.hasKey(SecurityConstants.TOKEN_BLACKLIST_PREFIX + jti);
        if (isBlack) {
            return ResponseUtils.writeErrorInfo(response, ResultCode.TOKEN_ACCESS_FORBIDDEN);
        }

        // 传递 payload 给其他微服务
        request = exchange.getRequest().mutate()
                .header(SecurityConstants.JWT_PAYLOAD_KEY, URLEncoder.encode(payload, StandardCharsets.UTF_8.name()))
                .build();
        exchange = exchange.mutate().request(request).build();
        return chain.filter(exchange);
    }


    /**
     * 线上演示环境禁止的操作请求判断
     *
     * @param request
     * @return
     */
    private boolean isForbiddenRequest(ServerHttpRequest request) {
        String requestPath = request.getPath().pathWithinApplication().value();
        if (GlobalConstants.ENV_PROD.equals(env)) {
            String method = request.getMethodValue();
            // PUT和DELETE方法禁止
            if (HttpMethod.DELETE.matches(method) || HttpMethod.PUT.matches(method)) {
                return !SecurityConstants.PROD_PERMIT_PATHS.stream().anyMatch(permitPath -> requestPath.contains(permitPath));
            } else if (HttpMethod.POST.matches(method)) {
                return SecurityConstants.PROD_FORBID_METHODS.stream().anyMatch(forbiddenPath -> requestPath.contains(forbiddenPath));
            }
        }
        return false;
    }

    /**
     * 获取JWT的载体payload
     *
     * @param authorization 请求头authorization
     * @return
     * @throws ParseException
     */
    public String getPayload(String authorization) throws ParseException {
        String payload = null;
        if (StrUtil.isNotBlank(authorization) && StrUtil.startWithIgnoreCase(authorization, SecurityConstants.JWT_PREFIX)) {
            authorization = StrUtil.replaceIgnoreCase(authorization, SecurityConstants.JWT_PREFIX, StrUtil.EMPTY);
            payload = JWSObject.parse(authorization).getPayload().toString();
        }
        return payload;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
