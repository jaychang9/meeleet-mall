package com.meeleet.cloud.sys.rpc.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meeleet.cloud.sys.pojo.convert.SysDictItemConvert;
import com.meeleet.cloud.sys.pojo.dto.SysDictItemDTO;
import com.meeleet.cloud.sys.pojo.entity.SysDictItem;
import com.meeleet.cloud.sys.pojo.query.SysDictItemPageQuery;
import com.meeleet.cloud.sys.rpc.ISysDictItemRpcService;
import com.meeleet.cloud.sys.service.ISysDictItemService;
import lombok.AllArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Collection;
import java.util.List;

@DubboService
@AllArgsConstructor
public class SysDictItemRpcServiceImpl implements ISysDictItemRpcService {

    private final ISysDictItemService sysDictItemService;

    @Override
    public boolean save(SysDictItemDTO sysDictItemDTO) {
        return sysDictItemService.save(SysDictItemConvert.INSTANCE.bizDTOToEntity(sysDictItemDTO));
    }

    @Override
    public boolean saveBatch(Collection<SysDictItemDTO> sysDictItemDTOList) {
        return sysDictItemService.saveBatch(SysDictItemConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysDictItemDTOList));
    }

    @Override
    public boolean saveBatch(Collection<SysDictItemDTO> sysDictItemDTOList, int batchSize) {
        return sysDictItemService.saveBatch(SysDictItemConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysDictItemDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysDictItemDTO> sysDictItemDTOList) {
        return sysDictItemService.saveOrUpdateBatch(SysDictItemConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysDictItemDTOList));
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysDictItemDTO> sysDictItemDTOList, int batchSize) {
        return sysDictItemService.saveOrUpdateBatch(SysDictItemConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysDictItemDTOList), batchSize);
    }

    @Override
    public boolean removeById(Long id) {
        return sysDictItemService.removeById(id);
    }

    @Override
    public boolean removeByIds(Collection<Long> idList) {
        return sysDictItemService.removeByIds(idList);
    }

    @Override
    public boolean updateById(SysDictItemDTO sysDictItemDTO) {
        return sysDictItemService.updateById(SysDictItemConvert.INSTANCE.bizDTOToEntity(sysDictItemDTO));
    }

    @Override
    public boolean updateBatchById(Collection<SysDictItemDTO> sysDictItemDTOList) {
        return sysDictItemService.updateBatchById(SysDictItemConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysDictItemDTOList));
    }

    @Override
    public boolean updateBatchById(Collection<SysDictItemDTO> sysDictItemDTOList, int batchSize) {
        return sysDictItemService.updateBatchById(SysDictItemConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysDictItemDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdate(SysDictItemDTO sysDictItemDTO) {
        return sysDictItemService.saveOrUpdate(SysDictItemConvert.INSTANCE.bizDTOToEntity(sysDictItemDTO));
    }

    @Override
    public SysDictItemDTO findById(Long id) {
        return SysDictItemConvert.INSTANCE.entityToBizDTO(sysDictItemService.getById(id));
    }

    @Override
    public List<SysDictItemDTO> listByIds(Collection<Long> idList) {
        return SysDictItemConvert.INSTANCE.entityListToBizDTOList(sysDictItemService.listByIds(idList));
    }

    @Override
    public int count() {
        return sysDictItemService.count();
    }

    @Override
    public List<SysDictItemDTO> list() {
        return SysDictItemConvert.INSTANCE.entityListToBizDTOList(sysDictItemService.list());
    }

    @Override
    public IPage<SysDictItemDTO> page(int current, int size) {
        Page<SysDictItem> page = sysDictItemService.page(Page.of(current, size));
        return page.convert(SysDictItemConvert.INSTANCE::entityToBizDTO);
    }

    @Override
    public IPage<SysDictItemDTO> page(SysDictItemPageQuery pageQuery) {
        LambdaQueryWrapper<SysDictItem> queryWrapper = new LambdaQueryWrapper<>();
        if (StrUtil.isNotBlank(pageQuery.getNameLike())) {
            queryWrapper.like(SysDictItem::getName,pageQuery.getNameLike());
        }
        Page<SysDictItem> pageParam = new Page().setCurrent(pageQuery.getCurrent()).setSize(pageQuery.getSize());
        Page<SysDictItem> page = sysDictItemService.page(pageParam, queryWrapper);
        return page.convert(SysDictItemConvert.INSTANCE::entityToBizDTO);
    }
}
