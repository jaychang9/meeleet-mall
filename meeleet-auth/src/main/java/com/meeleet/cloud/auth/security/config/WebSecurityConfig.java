package com.meeleet.cloud.auth.security.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.meeleet.cloud.auth.security.core.userdetails.member.MemberUserDetailsServiceImpl;
import com.meeleet.cloud.auth.security.core.userdetails.sysuser.SysUserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


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
                // swagger2用以下代码
                //.antMatchers("/webjars/**", "/swagger-ui.html", "/swagger-resources/**", "/v2/api-docs").permitAll()
                // knife4j用以下代码
                // .antMatchers("/webjars/**", "/doc.html", "/swagger-resources/**", "/v2/api-docs").permitAll()
                // spring-doc swagger3用以下代码
                .antMatchers("/webjars/**", "/swagger-ui/**", "/swagger-ui.html", "/swagger-resources/**", "/v3/api-docs/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    /**
     * 认证管理对象
     *
     * @return
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 密码编码器
     * <p>
     * 委托方式，根据密码的前缀选择对应的encoder，例如：{bcypt}前缀->标识BCYPT算法加密；{noop}->标识不使用任何加密即明文的方式
     * 密码判读 DaoAuthenticationProvider#additionalAuthenticationChecks
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}