package com.meeleet.mall.ums.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meeleet.cloud.common.constant.GlobalConstants;
import com.meeleet.mall.ums.dao.MemberMapper;
import com.meeleet.mall.ums.pojo.dto.MemberAuthInfoDTO;
import com.meeleet.mall.ums.pojo.dto.MemberDTO;
import com.meeleet.mall.ums.pojo.dto.MemberInfoDTO;
import com.meeleet.mall.ums.pojo.entity.Member;
import com.meeleet.mall.ums.pojo.vo.MemberVO;
import com.meeleet.mall.ums.service.IMemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {


    @Override
    public IPage<Member> list(Page<Member> page, String nickname) {
        List<Member> list = this.baseMapper.list(page, nickname);
        page.setRecords(list);
        return page;
    }


    /**
     * 根据 openid 获取会员认证信息
     *
     * @param openid
     * @return
     */
    @Override
    public MemberAuthInfoDTO getByOpenid(String openid) {
        Member member = this.getOne(new LambdaQueryWrapper<Member>()
                .eq(Member::getOpenid, openid)
                .select(Member::getId,
                        Member::getOpenid,
                        Member::getStatus
                )
        );
        MemberAuthInfoDTO memberAuth = null;
        if (member != null) {
            memberAuth = new MemberAuthInfoDTO()
                    .setMemberId(member.getId())
                    .setUsername(member.getOpenid())
                    .setStatus(member.getStatus());
        }
        return memberAuth;
    }

    /**
     * 根据手机号获取会员认证信息
     *
     * @param mobile
     * @return
     */
    @Override
    public MemberAuthInfoDTO getByMobile(String mobile) {
        Member member = this.getOne(new LambdaQueryWrapper<Member>()
                .eq(Member::getMobile, mobile)
                .select(Member::getId,
                        Member::getOpenid,
                        Member::getStatus
                )
        );

        MemberAuthInfoDTO memberAuth = null;
        if (member != null) {
            memberAuth = new MemberAuthInfoDTO()
                    .setMemberId(member.getId())
                    .setUsername(member.getMobile())
                    .setStatus(member.getStatus());
        }
        return memberAuth;
    }

    @Override
    public MemberAuthInfoDTO getByUsername(String username) {
        Member member = this.getOne(new LambdaQueryWrapper<Member>()
                .eq(Member::getUsername, username)
                .select(Member::getId,
                        Member::getUsername,
                        Member::getPassword,
                        Member::getStatus
                )
        );

        MemberAuthInfoDTO memberAuth = null;
        if (member != null) {
            memberAuth = new MemberAuthInfoDTO()
                    .setMemberId(member.getId())
                    .setUsername(member.getUsername())
                    .setPassword(member.getPassword())
                    .setStatus(member.getStatus());
        }
        return memberAuth;
    }

    /**
     * 新增会员
     *
     * @param memberDTO
     * @return
     */
    @Override
    public Long addMember(MemberDTO memberDTO) {
        Member umsMember = new Member();
        BeanUtil.copyProperties(memberDTO, umsMember);
        umsMember.setStatus(GlobalConstants.STATUS_YES);

        boolean result = this.save(umsMember);
        Assert.isTrue(result, "新增会员失败");
        return umsMember.getId();
    }

    /**
     * 获取登录会员信息
     *
     * @return
     */
    @Override
    public MemberVO getCurrentMemberInfo(Long memberId) {
        Member umsMember = this.getOne(new LambdaQueryWrapper<Member>()
                .eq(Member::getId, memberId)
                .select(Member::getId,
                        Member::getNickname,
                        Member::getAvatarUrl,
                        Member::getMobile,
                        Member::getBalance
                )
        );
        MemberVO memberVO = new MemberVO();
        BeanUtil.copyProperties(umsMember, memberVO);
        return memberVO;
    }


    /**
     * 「实验室」修改会员余额
     *
     * @param memberId
     * @param balance  会员余额
     * @return
     */
    @Override
    public boolean updateBalance(Long memberId, Long balance) {
        boolean result = this.update(new LambdaUpdateWrapper<Member>()
                .eq(Member::getId, memberId)
                .set(Member::getBalance, balance)
        );
        return result;
    }

    /**
     * 「实验室」扣减账户余额
     *
     * @param memberId
     * @param amount    扣减金额
     * @return
     */
    @Override
    @Transactional
    public boolean deductBalance(Long memberId, Long amount) {
        boolean result = this.update(new LambdaUpdateWrapper<Member>()
                .setSql("balance = balance - " + amount)
                .eq(Member::getId, memberId)
        );
        return result;
    }

    /**
     * 「实验室」获取会员信息
     *
     * @param memberId
     * @return
     */
    @Override
    public MemberInfoDTO getMemberInfo(Long memberId) {
        MemberInfoDTO memberInfoDTO = new MemberInfoDTO();
        Member umsMember = this.getById(memberId);
        if (umsMember != null) {
            BeanUtil.copyProperties(umsMember, memberInfoDTO);
        }
        return memberInfoDTO;
    }
}
