package com.meeleet.cloud.auth.security.core.userdetails.member;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.meeleet.cloud.common.auth.security.userdetails.ExtUserDetailsService;
import com.meeleet.cloud.common.constant.StringConstant;
import com.meeleet.cloud.common.result.ResultCode;
import com.meeleet.cloud.common.security.enums.AuthenticationIdentityEnum;
import com.meeleet.mall.ums.pojo.dto.MemberAuthInfoDTO;
import com.meeleet.mall.ums.pojo.dto.MemberDTO;
import com.meeleet.mall.ums.rpc.IMemberRpcService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 商城会员用户认证服务
 *
 * @author jaychang
 */
@Service("memberUserDetailsService")
public class MemberUserDetailsServiceImpl implements ExtUserDetailsService {

    @DubboReference
    private IMemberRpcService memberRpcService;

    /**
     * 手机号码认证方式
     *
     * @param mobile
     * @return
     */
    public UserDetails loadUserByMobile(String mobile) {
        MemberAuthInfoDTO member = memberRpcService.loadUserByMobile(mobile);
        return createUserDetails(member, AuthenticationIdentityEnum.MOBILE);
    }

    /**
     * openid 认证方式
     *
     * @param openId
     * @return
     */
    public UserDetails loadUserByOpenid(String openid) {
        MemberAuthInfoDTO member = memberRpcService.loadUserByOpenid(openid);
        return createUserDetails(member, AuthenticationIdentityEnum.OPENID);
    }

    /**
     * username 认证方式
     *
     * @param username
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberAuthInfoDTO member = memberRpcService.loadUserByUsername(username);
        return createUserDetails(member, AuthenticationIdentityEnum.USERNAME);
    }

    private UserDetails createUserDetails(MemberAuthInfoDTO member, AuthenticationIdentityEnum authenticationIdentityEnum) {
        MemberUserDetails userDetails = null;
        if (null != member) {
            userDetails = new MemberUserDetails(member);
            // 认证身份标识
            userDetails.setAuthenticationIdentity(authenticationIdentityEnum.getValue());
        }
        if (userDetails == null) {
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

    @Override
    public void addUser(Map<String, Object> userInfo) {
        MemberDTO memberDTO = BeanUtil.mapToBean(userInfo, MemberDTO.class, true, CopyOptions.create());
        memberDTO.setUsername(StringConstant.USERNAME_PREFIX + memberDTO.getMobile());
        memberRpcService.addMember(memberDTO);
    }
}
