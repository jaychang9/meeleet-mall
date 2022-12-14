package com.meeleet.mall.ums.rpc.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meeleet.mall.ums.pojo.convert.MemberConvert;
import com.meeleet.mall.ums.pojo.dto.MemberAuthInfoDTO;
import com.meeleet.mall.ums.pojo.dto.MemberDTO;
import com.meeleet.mall.ums.pojo.entity.Member;
import com.meeleet.mall.ums.rpc.IMemberRpcService;
import com.meeleet.mall.ums.service.IMemberService;
import lombok.AllArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@DubboService
@AllArgsConstructor
public class MemberRpcServiceImpl implements IMemberRpcService {

    private final IMemberService memberService;

    @Override
    public boolean save(MemberDTO umsMemberDTO) {
        return memberService.save(MemberConvert.INSTANCE.bizDTOToEntity(umsMemberDTO));
    }

    @Override
    public boolean saveBatch(Collection<MemberDTO> umsMemberDTOList) {
        return memberService.saveBatch(MemberConvert.INSTANCE.bizDTOCollectionToEntityCollection(umsMemberDTOList));
    }

    @Override
    public boolean saveBatch(Collection<MemberDTO> umsMemberDTOList, int batchSize) {
        return memberService.saveBatch(MemberConvert.INSTANCE.bizDTOCollectionToEntityCollection(umsMemberDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<MemberDTO> umsMemberDTOList) {
        return memberService.saveOrUpdateBatch(MemberConvert.INSTANCE.bizDTOCollectionToEntityCollection(umsMemberDTOList));
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<MemberDTO> umsMemberDTOList, int batchSize) {
        return memberService.saveOrUpdateBatch(MemberConvert.INSTANCE.bizDTOCollectionToEntityCollection(umsMemberDTOList), batchSize);
    }

    @Override
    public boolean removeById(Long id) {
        return memberService.removeById(id);
    }

    @Override
    public boolean removeByIds(Collection<Long> idList) {
        return memberService.removeByIds(idList);
    }

    @Override
    public boolean updateById(MemberDTO umsMemberDTO) {
        return memberService.updateById(MemberConvert.INSTANCE.bizDTOToEntity(umsMemberDTO));
    }

    @Override
    public boolean updateBatchById(Collection<MemberDTO> umsMemberDTOList) {
        return memberService.updateBatchById(MemberConvert.INSTANCE.bizDTOCollectionToEntityCollection(umsMemberDTOList));
    }

    @Override
    public boolean updateBatchById(Collection<MemberDTO> umsMemberDTOList, int batchSize) {
        return memberService.updateBatchById(MemberConvert.INSTANCE.bizDTOCollectionToEntityCollection(umsMemberDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdate(MemberDTO umsMemberDTO) {
        return memberService.saveOrUpdate(MemberConvert.INSTANCE.bizDTOToEntity(umsMemberDTO));
    }

    @Override
    public MemberDTO findById(Long id) {
        return MemberConvert.INSTANCE.entityToBizDTO(memberService.getById(id));
    }

    @Override
    public List<MemberDTO> listByIds(Collection<Long> idList) {
        return MemberConvert.INSTANCE.entityListToBizDTOList(memberService.listByIds(idList));
    }

    @Override
    public long count() {
        return memberService.count();
    }

    @Override
    public List<MemberDTO> list() {
        return MemberConvert.INSTANCE.entityListToBizDTOList(memberService.list());
    }

    @Override
    public IPage<MemberDTO> page(int current, int size) {
        IPage<Member> page = memberService.page(Page.of(current, size));
        return page.convert(MemberConvert.INSTANCE::entityToBizDTO);
    }

    @Override
    public Long addMember(MemberDTO member) {
        return memberService.addMember(member);
    }

    @Override
    public String findMemberOpenId(Long memberId) {
        Member member = memberService.getOne(
                new LambdaQueryWrapper<Member>()
                        .eq(Member::getId, memberId)
                        .select(Member::getOpenid)
        );
        return Optional.ofNullable(member).orElse(new Member()).getOpenid();
    }

    @Override
    public MemberAuthInfoDTO loadUserByOpenid(String openid) {
        return memberService.getByOpenid(openid);
    }

    @Override
    public MemberAuthInfoDTO loadUserByMobile(String mobile) {
        return memberService.getByMobile(mobile);
    }

    @Override
    public MemberAuthInfoDTO loadUserByUsername(String username) {
        return memberService.getByUsername(username);
    }

}
