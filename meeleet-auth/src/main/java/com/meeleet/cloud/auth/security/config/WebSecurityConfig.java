package com.meeleet.cloud.auth.security.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.meeleet.cloud.auth.security.core.userdetails.member.MemberUserDetailsServiceImpl;
import com.meeleet.cloud.auth.security.core.userdetails.sysuser.SysUserDetailsServiceImpl;
import com.meeleet.cloud.common.auth.security.extension.mobile.SmsCodeAuthenticationProvider;
import com.meeleet.cloud.common.auth.security.extension.password.DaoxAuthenticationProvider;
import com.meeleet.cloud.common.auth.security.extension.wechat.WechatAuthenticationProvider;
import com.meeleet.cloud.common.auth.security.userdetails.ExtUserDetailsService;
import com.meeleet.cloud.common.security.constant.SecurityConstants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jaychang
 */
@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@Slf4j
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final SysUserDetailsServiceImpl sysUserDetailsService;
    private final MemberUserDetailsServiceImpl memberUserDetailsService;
    private final WxMaService wxMaService;
    private final StringRedisTemplate redisTemplate;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/oauth/**", "/sms-code/**").permitAll()
                // swagger2???????????????
                //.antMatchers("/webjars/**", "/swagger-ui.html", "/swagger-resources/**", "/v2/api-docs").permitAll()
                // knife4j???????????????
                // .antMatchers("/webjars/**", "/doc.html", "/swagger-resources/**", "/v2/api-docs").permitAll()
                // spring-doc swagger3???????????????
                .antMatchers("/webjars/**", "/swagger-ui/**", "/swagger-ui.html", "/swagger-resources/**", "/v3/api-docs/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    /**
     * ??????????????????
     *
     * @return
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(wechatAuthenticationProvider()).
                authenticationProvider(daoAuthenticationProvider()).
                authenticationProvider(smsCodeAuthenticationProvider());
    }

    /**
     * ????????????????????????????????????
     *
     * @return
     */
    @Bean
    public SmsCodeAuthenticationProvider smsCodeAuthenticationProvider() {
        SmsCodeAuthenticationProvider provider = new SmsCodeAuthenticationProvider();
        provider.setUserDetailsServiceMap(userDetailsServiceMap());
        provider.setRedisTemplate(redisTemplate);
        return provider;
    }

    /**
     * ???????????????????????????
     *
     * @return
     */
    @Bean
    public WechatAuthenticationProvider wechatAuthenticationProvider() {
        WechatAuthenticationProvider provider = new WechatAuthenticationProvider();
        provider.setUserDetailsServiceMap(userDetailsServiceMap());
        provider.setWxMaService(wxMaService);
        return provider;
    }


    /**
     * ????????????????????????????????????
     *
     * @return
     */
    @Bean
    public DaoxAuthenticationProvider daoAuthenticationProvider() {
        DaoxAuthenticationProvider provider = new DaoxAuthenticationProvider();
        provider.setUserDetailsServiceMap(userDetailsServiceMap());
        provider.setPasswordEncoder(passwordEncoder());
        // ????????????????????????????????? ??????:true-?????????false-????????????
        provider.setHideUserNotFoundExceptions(false);
        return provider;
    }

    /**
     * ????????????????????????????????????????????????grant_type?????????
     *
     * @return
     */
    @Bean
    public Map<String, ExtUserDetailsService> userDetailsServiceMap() {
        Map<String, ExtUserDetailsService> clientIdUserDetailsServiceMap = new HashMap<>();
        clientIdUserDetailsServiceMap.put(SecurityConstants.ADMIN_CLIENT_ID,sysUserDetailsService);
        clientIdUserDetailsServiceMap.put(SecurityConstants.APP_CLIENT_ID,memberUserDetailsService);
        clientIdUserDetailsServiceMap.put(SecurityConstants.WEAPP_CLIENT_ID,memberUserDetailsService);
        return clientIdUserDetailsServiceMap;
    }


    /**
     * ???????????????
     * <p>
     * ???????????????????????????????????????????????????encoder????????????{bcypt}??????->??????BCYPT???????????????{noop}->?????????????????????????????????????????????
     * ???????????? DaoAuthenticationProvider#additionalAuthenticationChecks
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}