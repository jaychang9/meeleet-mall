package com.meeleet.cloud.sys.rpc.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meeleet.cloud.sys.pojo.convert.SysDictConvert;
import com.meeleet.cloud.sys.pojo.dto.SysDictDTO;
import com.meeleet.cloud.sys.pojo.entity.SysDict;
import com.meeleet.cloud.sys.rpc.ISysDictRpcService;
import com.meeleet.cloud.sys.service.ISysDictService;
import lombok.AllArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Collection;
import java.util.List;

@DubboService
@AllArgsConstructor
public class SysDictRpcServiceImpl implements ISysDictRpcService {

    private final ISysDictService sysDictService;

    @Override
    public boolean save(SysDictDTO sysDictDTO) {
        return sysDictService.save(SysDictConvert.INSTANCE.bizDTOToEntity(sysDictDTO));
    }

    @Override
    public boolean saveBatch(Collection<SysDictDTO> sysDictDTOList) {
        return sysDictService.saveBatch(SysDictConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysDictDTOList));
    }

    @Override
    public boolean saveBatch(Collection<SysDictDTO> sysDictDTOList, int batchSize) {
        return sysDictService.saveBatch(SysDictConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysDictDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysDictDTO> sysDictDTOList) {
        return sysDictService.saveOrUpdateBatch(SysDictConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysDictDTOList));
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysDictDTO> sysDictDTOList, int batchSize) {
        return sysDictService.saveOrUpdateBatch(SysDictConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysDictDTOList), batchSize);
    }

    @Override
    public boolean removeById(Long id) {
        return sysDictService.removeById(id);
    }

    @Override
    public boolean removeByIds(Collection<Long> idList) {
        return sysDictService.removeByIds(idList);
    }

    @Override
    public boolean updateById(SysDictDTO sysDictDTO) {
        return sysDictService.updateById(SysDictConvert.INSTANCE.bizDTOToEntity(sysDictDTO));
    }

    @Override
    public boolean updateBatchById(Collection<SysDictDTO> sysDictDTOList) {
        return sysDictService.updateBatchById(SysDictConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysDictDTOList));
    }

    @Override
    public boolean updateBatchById(Collection<SysDictDTO> sysDictDTOList, int batchSize) {
        return sysDictService.updateBatchById(SysDictConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysDictDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdate(SysDictDTO sysDictDTO) {
        return sysDictService.saveOrUpdate(SysDictConvert.INSTANCE.bizDTOToEntity(sysDictDTO));
    }

    @Override
    public SysDictDTO findById(Long id) {
        return SysDictConvert.INSTANCE.entityToBizDTO(sysDictService.getById(id));
    }

    @Override
    public List<SysDictDTO> listByIds(Collection<Long> idList) {
        return SysDictConvert.INSTANCE.entityListToBizDTOList(sysDictService.listByIds(idList));
    }

    @Override
    public int count() {
        return sysDictService.count();
    }

    @Override
    public List<SysDictDTO> list() {
        return SysDictConvert.INSTANCE.entityListToBizDTOList(sysDictService.list());
    }

    @Override
    public IPage<SysDictDTO> page(int current, int size) {
        IPage<SysDict> page = sysDictService.page(Page.of(current, size));
        return page.convert(SysDictConvert.INSTANCE::entityToBizDTO);
    }

    @Override
    public boolean updateDictById(Long id, SysDictDTO sysDictDTO) {
        return sysDictService.updateDictById(id,SysDictConvert.INSTANCE.bizDTOToEntity(sysDictDTO));
    }

    @Override
    public boolean deleteDictByIds(String ids) {
        return sysDictService.deleteDictByIds(ids);
    }
}
