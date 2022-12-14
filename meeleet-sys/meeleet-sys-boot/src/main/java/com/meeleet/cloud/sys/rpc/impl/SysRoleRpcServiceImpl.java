package com.meeleet.cloud.sys.rpc.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meeleet.cloud.sys.pojo.convert.SysRoleConvert;
import com.meeleet.cloud.sys.pojo.dto.SysRoleDTO;
import com.meeleet.cloud.sys.pojo.entity.SysRole;
import com.meeleet.cloud.sys.rpc.ISysRoleRpcService;
import com.meeleet.cloud.sys.service.ISysRoleService;
import lombok.AllArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Collection;
import java.util.List;

@DubboService
@AllArgsConstructor
public class SysRoleRpcServiceImpl implements ISysRoleRpcService {

    private final ISysRoleService sysRoleService;

    @Override
    public boolean save(SysRoleDTO sysRoleDTO) {
        return sysRoleService.save(SysRoleConvert.INSTANCE.bizDTOToEntity(sysRoleDTO));
    }

    @Override
    public boolean saveBatch(Collection<SysRoleDTO> sysRoleDTOList) {
        return sysRoleService.saveBatch(SysRoleConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysRoleDTOList));
    }

    @Override
    public boolean saveBatch(Collection<SysRoleDTO> sysRoleDTOList, int batchSize) {
        return sysRoleService.saveBatch(SysRoleConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysRoleDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysRoleDTO> sysRoleDTOList) {
        return sysRoleService.saveOrUpdateBatch(SysRoleConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysRoleDTOList));
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysRoleDTO> sysRoleDTOList, int batchSize) {
        return sysRoleService.saveOrUpdateBatch(SysRoleConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysRoleDTOList), batchSize);
    }

    @Override
    public boolean removeById(Long id) {
        return sysRoleService.removeById(id);
    }

    @Override
    public boolean removeByIds(Collection<Long> idList) {
        return sysRoleService.removeByIds(idList);
    }

    @Override
    public boolean updateById(SysRoleDTO sysRoleDTO) {
        return sysRoleService.updateById(SysRoleConvert.INSTANCE.bizDTOToEntity(sysRoleDTO));
    }

    @Override
    public boolean updateBatchById(Collection<SysRoleDTO> sysRoleDTOList) {
        return sysRoleService.updateBatchById(SysRoleConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysRoleDTOList));
    }

    @Override
    public boolean updateBatchById(Collection<SysRoleDTO> sysRoleDTOList, int batchSize) {
        return sysRoleService.updateBatchById(SysRoleConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysRoleDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdate(SysRoleDTO sysRoleDTO) {
        return sysRoleService.saveOrUpdate(SysRoleConvert.INSTANCE.bizDTOToEntity(sysRoleDTO));
    }

    @Override
    public SysRoleDTO findById(Long id) {
        return SysRoleConvert.INSTANCE.entityToBizDTO(sysRoleService.getById(id));
    }

    @Override
    public List<SysRoleDTO> listByIds(Collection<Long> idList) {
        return SysRoleConvert.INSTANCE.entityListToBizDTOList(sysRoleService.listByIds(idList));
    }

    @Override
    public long count() {
        return sysRoleService.count();
    }

    @Override
    public List<SysRoleDTO> list() {
        return SysRoleConvert.INSTANCE.entityListToBizDTOList(sysRoleService.list());
    }

    @Override
    public IPage<SysRoleDTO> page(int current, int size) {
        IPage<SysRole> page = sysRoleService.page(Page.of(current, size));
        return page.convert(SysRoleConvert.INSTANCE::entityToBizDTO);
    }

    @Override
    public boolean delete(List<Long> ids) {
        return sysRoleService.delete(ids);
    }
}
