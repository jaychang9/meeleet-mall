package com.meeleet.cloud.auth.security.core.userdetails.sysuser;

import com.meeleet.cloud.common.auth.security.userdetails.ExtUserDetailsService;
import com.meeleet.cloud.common.result.ResultCode;
import com.meeleet.cloud.sys.pojo.dto.AuthUserDTO;
import com.meeleet.cloud.sys.rpc.ISysUserRpcService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service("sysUserDetailsService")
public class SysUserDetailsServiceImpl implements ExtUserDetailsService {
    @DubboReference
    private ISysUserRpcService sysUserRpcService;

    // TODO 测试过期刷新，需要修改过期时间,为了使得即时生效，缓存功能暂时注释掉
    @Cacheable(cacheNames = "auth", key = "'sysuser:'+#username")
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUserDTO authUserDTO = sysUserRpcService.findAuthInfoByUsername(username);
        return createUserDetails(authUserDTO);
    }

    // TODO 测试过期刷新，需要修改过期时间,为了使得即时生效，缓存功能暂时注释掉
    @Cacheable(cacheNames = "auth", key = "'sysuser:'+#mobile")
    public UserDetails loadUserByMobile(String mobile) throws UsernameNotFoundException {
        AuthUserDTO authUserDTO = sysUserRpcService.findAuthInfoByMobile(mobile);
        return createUserDetails(authUserDTO);
    }

    private UserDetails createUserDetails(AuthUserDTO authUserDTO) {
        SysUserDetails userDetails = null;
        if (Objects.nonNull(authUserDTO)) {
            userDetails = new SysUserDetails(authUserDTO);
        }
        if (Objects.isNull(userDetails)) {
            throw new UsernameNotFoundException(ResultCode.USER_NOT_EXIST.getMessage());
        } else if (!userDetails.isEnabled()) {
            throw new DisabledException("该账户已被禁用!");
        } else if (!userDetails.isAccountNonLocked()) {
            throw new LockedException("该账号已被锁定!");
        } else if (!userDetails.isAccountNonExpired()) {
            throw new AccountExpiredException("该账号已过期!");
        }
        return userDetails;
    }
}
