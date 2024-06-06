package com.meeleet.cloud.auth.security.core.userdetails.member;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.google.common.collect.Sets;
import com.meeleet.cloud.common.auth.security.userdetails.ExtUserDetailsService;
import com.meeleet.cloud.common.security.constant.SecurityConstants;
import com.meeleet.cloud.common.security.enums.AuthenticationIdentityEnum;
import com.meeleet.mall.ums.pojo.dto.MemberAuthInfoDTO;
import com.meeleet.mall.ums.pojo.dto.MemberDTO;
import com.meeleet.mall.ums.rpc.IMemberRpcService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
 * 商城会员用户认证服务
 *
 * @author jaychang
 */
@Service("memberUserDetailsService")
public class MemberUserDetailsServiceImpl implements ExtUserDetailsService {

    private static final Set<String> SUPPORTED_CLIENT_IDS = Sets.newHashSet(SecurityConstants.APP_CLIENT_ID, SecurityConstants.WEAPP_CLIENT_ID);

    @DubboReference
    private IMemberRpcService memberRpcService;

    private static final String USERNAME_PREFIX = "m";

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
        return userDetails;
    }

    @Override
    public void addUser(Map<String, Object> userInfo) {
        MemberDTO memberDTO = BeanUtil.mapToBean(userInfo, MemberDTO.class, true, CopyOptions.create());
        memberDTO.setUsername(USERNAME_PREFIX + memberDTO.getMobile());
        memberRpcService.addMember(memberDTO);
    }

    @Override
    public boolean supports(String clientId) {
        return SUPPORTED_CLIENT_IDS.contains(clientId);
    }
}
