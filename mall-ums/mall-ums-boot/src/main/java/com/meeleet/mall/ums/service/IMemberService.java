package com.meeleet.mall.ums.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.meeleet.mall.ums.pojo.dto.MemberAuthInfoDTO;
import com.meeleet.mall.ums.pojo.dto.MemberDTO;
import com.meeleet.mall.ums.pojo.dto.MemberInfoDTO;
import com.meeleet.mall.ums.pojo.entity.Member;
import com.meeleet.mall.ums.pojo.vo.MemberVO;

public interface IMemberService extends IService<Member> {
    IPage<Member> list(Page<Member> page, String nickname);

    /**
     * 根据 openid 获取会员认证信息
     *
     * @param openid
     * @return
     */
    MemberAuthInfoDTO getByOpenid(String openid);

    /**
     * 根据手机号获取会员认证信息
     *
     * @param mobile
     * @return
     */
    MemberAuthInfoDTO getByMobile(String mobile);

    /**
     * 根据用户名获取会员认证信息
     * @param username
     * @return
     */
    MemberAuthInfoDTO getByUsername(String username);

    /**
     * 新增会员
     *
     * @param member
     * @return
     */
    Long addMember(MemberDTO member);

    /**
     * 获取登录会员信息
     *
     * @param memberId 会员ID
     * @return
     */
    MemberVO getCurrentMemberInfo(Long memberId);


    /**
     * 「实验室」修改会员余额
     *
     * @param memberId
     * @param balance  会员余额
     * @return
     */
    boolean updateBalance(Long memberId, Long balance);

    /**
     * 「实验室」扣减账户余额
     *
     * @param memberId
     * @param amount   扣减金额
     * @return
     */
    boolean deductBalance(Long memberId, Long amount);

    /**
     * 「实验室」获取会员信息
     *
     * @param memberId
     * @return
     */
    MemberInfoDTO getMemberInfo(Long memberId);


}
