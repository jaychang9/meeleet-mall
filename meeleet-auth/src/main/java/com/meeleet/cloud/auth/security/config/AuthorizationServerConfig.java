package com.meeleet.cloud.auth.security.config;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.meeleet.cloud.auth.security.core.clientdetails.ClientDetailsServiceImpl;
import com.meeleet.cloud.auth.security.core.userdetails.member.MemberUserDetails;
import com.meeleet.cloud.auth.security.core.userdetails.member.MemberUserDetailsServiceImpl;
import com.meeleet.cloud.auth.security.core.userdetails.sysuser.SysUserDetails;
import com.meeleet.cloud.auth.security.core.userdetails.sysuser.SysUserDetailsServiceImpl;
import com.meeleet.cloud.common.auth.security.extension.captcha.CaptchaTokenGranter;
import com.meeleet.cloud.common.auth.security.extension.mobile.SmsCodeTokenGranter;
import com.meeleet.cloud.common.auth.security.extension.refresh.PreAuthenticatedUserDetailsService;
import com.meeleet.cloud.common.auth.security.extension.wechat.WechatTokenGranter;
import com.meeleet.cloud.common.auth.security.filter.CustomClientCredentialsTokenEndpointFilter;
import com.meeleet.cloud.common.auth.security.userdetails.ExtUserDetailsService;
import com.meeleet.cloud.common.result.R;
import com.meeleet.cloud.common.result.ResultCode;
import com.meeleet.cloud.common.security.constant.SecurityConstants;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.CompositeTokenGranter;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.util.*;

@Configuration
@EnableAuthorizationServer
@AllArgsConstructor
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    private final AuthenticationManager authenticationManager;
    private final ClientDetailsServiceImpl clientDetailsService;
    private final SysUserDetailsServiceImpl sysUserDetailsService;
    private final MemberUserDetailsServiceImpl memberUserDetailsService;
    private final StringRedisTemplate stringRedisTemplate;

    /**
     * OAuth2????????????Dubbo???????????????
     */
    @Override
    @SneakyThrows
    public void configure(ClientDetailsServiceConfigurer clients) {
        clients.withClientDetails(clientDetailsService);
    }


    /**
     * ???????????????authorization??????????????????token?????????????????????????????????(token services)
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        // Token??????
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> tokenEnhancers = new ArrayList<>();
        tokenEnhancers.add(tokenEnhancer());
        tokenEnhancers.add(jwtAccessTokenConverter());
        tokenEnhancerChain.setTokenEnhancers(tokenEnhancers);

        //token?????????????????? ?????????InMemoryTokenStore????????????????????????
        endpoints.tokenStore(jwtTokenStore());

        // ??????????????????????????????(???????????????????????????????????????????????????????????????)????????????
        List<TokenGranter> granterList = new ArrayList<>(Arrays.asList(endpoints.getTokenGranter()));

        // ????????????????????????????????????
        granterList.add(new CaptchaTokenGranter(endpoints.getTokenServices(), endpoints.getClientDetailsService(),
                endpoints.getOAuth2RequestFactory(), authenticationManager, stringRedisTemplate
        ));

        // ???????????????????????????????????????????????????
        granterList.add(new SmsCodeTokenGranter(endpoints.getTokenServices(), endpoints.getClientDetailsService(),
                endpoints.getOAuth2RequestFactory(), authenticationManager
        ));

        // ????????????????????????????????????
        granterList.add(new WechatTokenGranter(endpoints.getTokenServices(), endpoints.getClientDetailsService(),
                endpoints.getOAuth2RequestFactory(), authenticationManager
        ));

        CompositeTokenGranter compositeTokenGranter = new CompositeTokenGranter(granterList);
        endpoints
                .authenticationManager(authenticationManager)
                .accessTokenConverter(jwtAccessTokenConverter())
                .tokenEnhancer(tokenEnhancerChain)
                .tokenGranter(compositeTokenGranter)
                .tokenServices(tokenServices(endpoints));
    }

    /**
     * jwt token????????????
     */
    @Bean
    public JwtTokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    public DefaultTokenServices tokenServices(AuthorizationServerEndpointsConfigurer endpoints) {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> tokenEnhancers = new ArrayList<>();
        tokenEnhancers.add(tokenEnhancer());
        tokenEnhancers.add(jwtAccessTokenConverter());
        tokenEnhancerChain.setTokenEnhancers(tokenEnhancers);

        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(endpoints.getTokenStore());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setClientDetailsService(clientDetailsService);
        tokenServices.setTokenEnhancer(tokenEnhancerChain);

        // ???????????????????????????token?????????????????????ID??? UserDetailService ?????????Map
        Map<String, ExtUserDetailsService> clientUserDetailsServiceMap = new HashMap<>();
        clientUserDetailsServiceMap.put(SecurityConstants.ADMIN_CLIENT_ID, sysUserDetailsService); // ?????????????????????
        clientUserDetailsServiceMap.put(SecurityConstants.APP_CLIENT_ID, memberUserDetailsService); // Android???IOS???H5 ???????????????
        clientUserDetailsServiceMap.put(SecurityConstants.WEAPP_CLIENT_ID, memberUserDetailsService); // ????????????????????????

        // ??????token?????????????????????????????????????????????AuthenticationManager??????????????????????????????ID?????????????????????????????????????????????????????????
        PreAuthenticatedAuthenticationProvider provider = new PreAuthenticatedAuthenticationProvider();
        provider.setPreAuthenticatedUserDetailsService(new PreAuthenticatedUserDetailsService<>(clientUserDetailsServiceMap));
        tokenServices.setAuthenticationManager(new ProviderManager(Arrays.asList(provider)));

        /** refresh_token????????????????????????????????????(true)??????????????????(false)????????????true
         *  1 ???????????????access_token?????????????????? refresh_token?????????????????????????????????????????????????????????
         *  2 ??????????????????access_token?????????????????? refresh_token????????????????????????refresh_token??????????????????????????????????????????????????????????????????
         */
        tokenServices.setReuseRefreshToken(true);
        return tokenServices;

    }

    /**
     * ??????????????????????????????token??????
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setKeyPair(keyPair());
        return converter;
    }

    /**
     * ???????????????????????????(??????+??????)
     */
    @Bean
    public KeyPair keyPair() {
        KeyStoreKeyFactory factory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "123456".toCharArray());
        KeyPair keyPair = factory.getKeyPair("jwt", "123456".toCharArray());
        return keyPair;
    }


    /**
     * JWT????????????
     */
    @Bean
    public TokenEnhancer tokenEnhancer() {
        return (accessToken, authentication) -> {
            Map<String, Object> additionalInfo = MapUtil.newHashMap();
            Object principal = authentication.getUserAuthentication().getPrincipal();
            if (principal instanceof SysUserDetails) {
                SysUserDetails sysUserDetails = (SysUserDetails) principal;
                additionalInfo.put("userId", sysUserDetails.getUserId());
                additionalInfo.put("username", sysUserDetails.getUsername());
                additionalInfo.put("deptId", sysUserDetails.getDeptId());
                // ??????????????????(username:????????????)
                if (StrUtil.isNotBlank(sysUserDetails.getAuthenticationIdentity())) {
                    additionalInfo.put("authenticationIdentity", sysUserDetails.getAuthenticationIdentity());
                }
            } else if (principal instanceof MemberUserDetails) {
                MemberUserDetails memberUserDetails = (MemberUserDetails) principal;
                additionalInfo.put("memberId", memberUserDetails.getMemberId());
                additionalInfo.put("username", memberUserDetails.getUsername());
                // ??????????????????(mobile:????????????openId:???????????????????????????????????????)
                if (StrUtil.isNotBlank(memberUserDetails.getAuthenticationIdentity())) {
                    additionalInfo.put("authenticationIdentity", memberUserDetails.getAuthenticationIdentity());
                }
            }
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
            return accessToken;
        };
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        // ????????????????????????????????????
        OAuth2AuthenticationEntryPoint oAuth2AuthenticationEntryPoint = createOAuth2AuthenticationEntryPoint();
        CustomClientCredentialsTokenEndpointFilter clientCredentialsTokenEndpointFilter = new CustomClientCredentialsTokenEndpointFilter(security);
        // ??????????????????????????????????????????????????????
        clientCredentialsTokenEndpointFilter.afterPropertiesSet();
        clientCredentialsTokenEndpointFilter.setFilterProcessesUrl("/oauth/token");
        clientCredentialsTokenEndpointFilter.setAuthenticationEntryPoint(oAuth2AuthenticationEntryPoint);

        security.addTokenEndpointAuthenticationFilter(clientCredentialsTokenEndpointFilter);
        security.authenticationEntryPoint(oAuth2AuthenticationEntryPoint)
                .tokenKeyAccess("isAuthenticated()")
                .checkTokenAccess("isAuthenticated()");
    }

    /**
     * ?????????????????????????????????(????????????????????????Filter)
     */
    public OAuth2AuthenticationEntryPoint createOAuth2AuthenticationEntryPoint() {
        OAuth2AuthenticationEntryPoint oAuth2AuthenticationEntryPoint = new OAuth2AuthenticationEntryPoint() {
            @Override
            public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setCharacterEncoding(StandardCharsets.UTF_8.name());
                response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
                response.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
                R result = R.failed(ResultCode.CLIENT_AUTHENTICATION_FAILED);
                if (authException instanceof BadCredentialsException) {
                    result = R.failed(ResultCode.CLIENT_ID_OR_PASSWORD_ERROR);
                }
                response.getWriter().print(JSONUtil.toJsonStr(result));
                response.getWriter().flush();
            }
        };
        oAuth2AuthenticationEntryPoint.setTypeName("Form");
        oAuth2AuthenticationEntryPoint.setRealmName("oauth2/client");
        return oAuth2AuthenticationEntryPoint;
    }


}
