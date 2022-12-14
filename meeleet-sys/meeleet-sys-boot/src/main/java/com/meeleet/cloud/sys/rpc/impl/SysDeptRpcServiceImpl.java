package com.meeleet.cloud.sys.rpc.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meeleet.cloud.common.pojo.vo.OptionVO;
import com.meeleet.cloud.sys.pojo.convert.SysDeptConvert;
import com.meeleet.cloud.sys.pojo.dto.SysDeptDTO;
import com.meeleet.cloud.sys.pojo.entity.SysDept;
import com.meeleet.cloud.sys.pojo.vo.DeptVO;
import com.meeleet.cloud.sys.rpc.ISysDeptRpcService;
import com.meeleet.cloud.sys.service.ISysDeptService;
import lombok.AllArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Collection;
import java.util.List;


@DubboService
@AllArgsConstructor
public class SysDeptRpcServiceImpl implements ISysDeptRpcService {

    private final ISysDeptService sysDeptService;

    @Override
    public boolean save(SysDeptDTO sysDeptDTO) {
        return sysDeptService.save(SysDeptConvert.INSTANCE.bizDTOToEntity(sysDeptDTO));
    }

    @Override
    public boolean saveBatch(Collection<SysDeptDTO> sysDeptDTOList) {
        return sysDeptService.saveBatch(SysDeptConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysDeptDTOList));
    }

    @Override
    public boolean saveBatch(Collection<SysDeptDTO> sysDeptDTOList, int batchSize) {
        return sysDeptService.saveBatch(SysDeptConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysDeptDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysDeptDTO> sysDeptDTOList) {
        return sysDeptService.saveOrUpdateBatch(SysDeptConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysDeptDTOList));
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysDeptDTO> sysDeptDTOList, int batchSize) {
        return sysDeptService.saveOrUpdateBatch(SysDeptConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysDeptDTOList), batchSize);
    }

    @Override
    public boolean removeById(Long id) {
        return sysDeptService.removeById(id);
    }

    @Override
    public boolean removeByIds(Collection<Long> idList) {
        return sysDeptService.removeByIds(idList);
    }

    @Override
    public boolean updateById(SysDeptDTO sysDeptDTO) {
        return sysDeptService.updateById(SysDeptConvert.INSTANCE.bizDTOToEntity(sysDeptDTO));
    }

    @Override
    public boolean updateBatchById(Collection<SysDeptDTO> sysDeptDTOList) {
        return sysDeptService.updateBatchById(SysDeptConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysDeptDTOList));
    }

    @Override
    public boolean updateBatchById(Collection<SysDeptDTO> sysDeptDTOList, int batchSize) {
        return sysDeptService.updateBatchById(SysDeptConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysDeptDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdate(SysDeptDTO sysDeptDTO) {
        return sysDeptService.saveOrUpdate(SysDeptConvert.INSTANCE.bizDTOToEntity(sysDeptDTO));
    }

    @Override
    public SysDeptDTO findById(Long id) {
        return SysDeptConvert.INSTANCE.entityToBizDTO(sysDeptService.getById(id));
    }

    @Override
    public List<SysDeptDTO> listByIds(Collection<Long> idList) {
        return SysDeptConvert.INSTANCE.entityListToBizDTOList(sysDeptService.listByIds(idList));
    }

    @Override
    public long count() {
        return sysDeptService.count();
    }

    @Override
    public List<SysDeptDTO> list() {
        return SysDeptConvert.INSTANCE.entityListToBizDTOList(sysDeptService.list());
    }

    @Override
    public IPage<SysDeptDTO> page(int current, int size) {
        IPage<SysDept> page = sysDeptService.page(Page.of(current, size));
        return page.convert(SysDeptConvert.INSTANCE::entityToBizDTO);
    }

    @Override
    public List<DeptVO> listTableDepartments(Integer status, String name) {
        return sysDeptService.listTableDepartments(status, name);
    }

    @Override
    public List<OptionVO> listTreeSelectDepartments() {
        return sysDeptService.listTreeSelectDepartments();
    }

    @Override
    public Long saveDept(SysDeptDTO sysDeptDTO) {
        SysDept sysDept = SysDeptConvert.INSTANCE.bizDTOToEntity(sysDeptDTO);
        return sysDeptService.saveDept(sysDept);
    }

    @Override
    public boolean deleteByIds(String ids) {
        return sysDeptService.deleteByIds(ids);
    }
}
