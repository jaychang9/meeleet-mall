package com.meeleet.cloud.sys.rpc.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meeleet.cloud.sys.pojo.convert.SysUserRoleConvert;
import com.meeleet.cloud.sys.pojo.dto.SysUserRoleDTO;
import com.meeleet.cloud.sys.pojo.entity.SysUserRole;
import com.meeleet.cloud.sys.rpc.ISysUserRoleRpcService;
import com.meeleet.cloud.sys.service.ISysUserRoleService;
import lombok.AllArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Collection;
import java.util.List;

@DubboService
@AllArgsConstructor
public class SysUserRoleRpcServiceImpl implements ISysUserRoleRpcService {
    private final ISysUserRoleService sysUserRoleService;

    @Override
    public boolean save(SysUserRoleDTO sysUserRoleDTO) {
        return sysUserRoleService.save(SysUserRoleConvert.INSTANCE.bizDTOToEntity(sysUserRoleDTO));
    }

    @Override
    public boolean saveBatch(Collection<SysUserRoleDTO> sysUserRoleDTOList) {
        return sysUserRoleService.saveBatch(SysUserRoleConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysUserRoleDTOList));
    }

    @Override
    public boolean saveBatch(Collection<SysUserRoleDTO> sysUserRoleDTOList, int batchSize) {
        return sysUserRoleService.saveBatch(SysUserRoleConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysUserRoleDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysUserRoleDTO> sysUserRoleDTOList) {
        return sysUserRoleService.saveOrUpdateBatch(SysUserRoleConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysUserRoleDTOList));
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysUserRoleDTO> sysUserRoleDTOList, int batchSize) {
        return sysUserRoleService.saveOrUpdateBatch(SysUserRoleConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysUserRoleDTOList), batchSize);
    }

    @Override
    public boolean removeById(Long id) {
        return sysUserRoleService.removeById(id);
    }

    @Override
    public boolean removeByIds(Collection<Long> idList) {
        return sysUserRoleService.removeByIds(idList);
    }

    @Override
    public boolean updateById(SysUserRoleDTO sysUserRoleDTO) {
        return sysUserRoleService.updateById(SysUserRoleConvert.INSTANCE.bizDTOToEntity(sysUserRoleDTO));
    }

    @Override
    public boolean updateBatchById(Collection<SysUserRoleDTO> sysUserRoleDTOList) {
        return sysUserRoleService.updateBatchById(SysUserRoleConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysUserRoleDTOList));
    }

    @Override
    public boolean updateBatchById(Collection<SysUserRoleDTO> sysUserRoleDTOList, int batchSize) {
        return sysUserRoleService.updateBatchById(SysUserRoleConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysUserRoleDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdate(SysUserRoleDTO sysUserRoleDTO) {
        return sysUserRoleService.saveOrUpdate(SysUserRoleConvert.INSTANCE.bizDTOToEntity(sysUserRoleDTO));
    }

    @Override
    public SysUserRoleDTO findById(Long id) {
        return SysUserRoleConvert.INSTANCE.entityToBizDTO(sysUserRoleService.getById(id));
    }

    @Override
    public List<SysUserRoleDTO> listByIds(Collection<Long> idList) {
        return SysUserRoleConvert.INSTANCE.entityListToBizDTOList(sysUserRoleService.listByIds(idList));
    }

    @Override
    public long count() {
        return sysUserRoleService.count();
    }

    @Override
    public List<SysUserRoleDTO> list() {
        return SysUserRoleConvert.INSTANCE.entityListToBizDTOList(sysUserRoleService.list());
    }

    @Override
    public IPage<SysUserRoleDTO> page(int current, int size) {
        IPage<SysUserRole> page = sysUserRoleService.page(Page.of(current, size));
        return page.convert(SysUserRoleConvert.INSTANCE::entityToBizDTO);
    }

}
