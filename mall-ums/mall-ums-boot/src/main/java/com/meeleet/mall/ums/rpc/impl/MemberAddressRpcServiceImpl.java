package com.meeleet.mall.ums.rpc.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meeleet.mall.ums.pojo.convert.MemberAddressConvert;
import com.meeleet.mall.ums.pojo.dto.MemberAddressDTO;
import com.meeleet.mall.ums.pojo.entity.MemberAddress;
import com.meeleet.mall.ums.rpc.IMemberAddressRpcService;
import com.meeleet.mall.ums.service.IMemberAddressService;
import lombok.AllArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@DubboService
@AllArgsConstructor
public class MemberAddressRpcServiceImpl implements IMemberAddressRpcService {

    private final IMemberAddressService memberAddressService;

    @Override
    public boolean save(MemberAddressDTO memberAddressDTO) {
        return memberAddressService.save(MemberAddressConvert.INSTANCE.bizDTOToEntity(memberAddressDTO));
    }

    @Override
    public boolean saveBatch(Collection<MemberAddressDTO> memberAddressDTOList) {
        return memberAddressService.saveBatch(MemberAddressConvert.INSTANCE.bizDTOCollectionToEntityCollection(memberAddressDTOList));
    }

    @Override
    public boolean saveBatch(Collection<MemberAddressDTO> memberAddressDTOList, int batchSize) {
        return memberAddressService.saveBatch(MemberAddressConvert.INSTANCE.bizDTOCollectionToEntityCollection(memberAddressDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<MemberAddressDTO> memberAddressDTOList) {
        return memberAddressService.saveOrUpdateBatch(MemberAddressConvert.INSTANCE.bizDTOCollectionToEntityCollection(memberAddressDTOList));
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<MemberAddressDTO> memberAddressDTOList, int batchSize) {
        return memberAddressService.saveOrUpdateBatch(MemberAddressConvert.INSTANCE.bizDTOCollectionToEntityCollection(memberAddressDTOList), batchSize);
    }

    @Override
    public boolean removeById(Long id) {
        return memberAddressService.removeById(id);
    }

    @Override
    public boolean removeByIds(Collection<Long> idList) {
        return memberAddressService.removeByIds(idList);
    }

    @Override
    public boolean updateById(MemberAddressDTO memberAddressDTO) {
        return memberAddressService.updateById(MemberAddressConvert.INSTANCE.bizDTOToEntity(memberAddressDTO));
    }

    @Override
    public boolean updateBatchById(Collection<MemberAddressDTO> memberAddressDTOList) {
        return memberAddressService.updateBatchById(MemberAddressConvert.INSTANCE.bizDTOCollectionToEntityCollection(memberAddressDTOList));
    }

    @Override
    public boolean updateBatchById(Collection<MemberAddressDTO> memberAddressDTOList, int batchSize) {
        return memberAddressService.updateBatchById(MemberAddressConvert.INSTANCE.bizDTOCollectionToEntityCollection(memberAddressDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdate(MemberAddressDTO memberAddressDTO) {
        return memberAddressService.saveOrUpdate(MemberAddressConvert.INSTANCE.bizDTOToEntity(memberAddressDTO));
    }

    @Override
    public MemberAddressDTO findById(Long id) {
        return MemberAddressConvert.INSTANCE.entityToBizDTO(memberAddressService.getById(id));
    }

    @Override
    public List<MemberAddressDTO> listByIds(Collection<Long> idList) {
        return MemberAddressConvert.INSTANCE.entityListToBizDTOList(memberAddressService.listByIds(idList));
    }

    @Override
    public int count() {
        return memberAddressService.count();
    }

    @Override
    public List<MemberAddressDTO> list() {
        return MemberAddressConvert.INSTANCE.entityListToBizDTOList(memberAddressService.list());
    }

    @Override
    public IPage<MemberAddressDTO> page(int current, int size) {
        IPage<MemberAddress> page = memberAddressService.page(Page.of(current, size));
        return page.convert(MemberAddressConvert.INSTANCE::entityToBizDTO);
    }

    @Override
    public List<MemberAddressDTO> listCurrMemberAddresses(Long memberId) {
        List<MemberAddress> umsAddressList = memberAddressService.list(new LambdaQueryWrapper<MemberAddress>()
                .eq(MemberAddress::getMemberId, memberId)
                .orderByDesc(MemberAddress::getDefaulted) // 默认地址排在首位
        );
        List<MemberAddressDTO> memberAddressList = Optional.ofNullable(umsAddressList).orElse(new ArrayList<>()).stream()
                .map(umsAddress -> {
                    MemberAddressDTO memberAddressDTO = new MemberAddressDTO();
                    BeanUtil.copyProperties(umsAddress, memberAddressDTO);
                    return memberAddressDTO;
                }).collect(Collectors.toList());
        return memberAddressList;
    }
}
