package com.meeleet.cloud.sys.rpc.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meeleet.cloud.sys.pojo.convert.SysRolePermissionConvert;
import com.meeleet.cloud.sys.pojo.dto.RolePermsDTO;
import com.meeleet.cloud.sys.pojo.dto.SysRolePermissionDTO;
import com.meeleet.cloud.sys.pojo.entity.SysRolePermission;
import com.meeleet.cloud.sys.rpc.ISysRolePermissionRpcService;
import com.meeleet.cloud.sys.service.ISysRolePermissionService;
import lombok.AllArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Collection;
import java.util.List;

@DubboService
@AllArgsConstructor
public class SysRolePermissionRpcServiceImpl implements ISysRolePermissionRpcService {
    private final ISysRolePermissionService sysRolePermissionService;

    @Override
    public boolean save(SysRolePermissionDTO sysRolePermissionDTO) {
        return sysRolePermissionService.save(SysRolePermissionConvert.INSTANCE.bizDTOToEntity(sysRolePermissionDTO));
    }

    @Override
    public boolean saveBatch(Collection<SysRolePermissionDTO> sysRolePermissionDTOList) {
        return sysRolePermissionService.saveBatch(SysRolePermissionConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysRolePermissionDTOList));
    }

    @Override
    public boolean saveBatch(Collection<SysRolePermissionDTO> sysRolePermissionDTOList, int batchSize) {
        return sysRolePermissionService.saveBatch(SysRolePermissionConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysRolePermissionDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysRolePermissionDTO> sysRolePermissionDTOList) {
        return sysRolePermissionService.saveOrUpdateBatch(SysRolePermissionConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysRolePermissionDTOList));
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysRolePermissionDTO> sysRolePermissionDTOList, int batchSize) {
        return sysRolePermissionService.saveOrUpdateBatch(SysRolePermissionConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysRolePermissionDTOList), batchSize);
    }

    @Override
    public boolean removeById(Long id) {
        return sysRolePermissionService.removeById(id);
    }

    @Override
    public boolean removeByIds(Collection<Long> idList) {
        return sysRolePermissionService.removeByIds(idList);
    }

    @Override
    public boolean updateById(SysRolePermissionDTO sysRolePermissionDTO) {
        return sysRolePermissionService.updateById(SysRolePermissionConvert.INSTANCE.bizDTOToEntity(sysRolePermissionDTO));
    }

    @Override
    public boolean updateBatchById(Collection<SysRolePermissionDTO> sysRolePermissionDTOList) {
        return sysRolePermissionService.updateBatchById(SysRolePermissionConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysRolePermissionDTOList));
    }

    @Override
    public boolean updateBatchById(Collection<SysRolePermissionDTO> sysRolePermissionDTOList, int batchSize) {
        return sysRolePermissionService.updateBatchById(SysRolePermissionConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysRolePermissionDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdate(SysRolePermissionDTO sysRolePermissionDTO) {
        return sysRolePermissionService.saveOrUpdate(SysRolePermissionConvert.INSTANCE.bizDTOToEntity(sysRolePermissionDTO));
    }

    @Override
    public SysRolePermissionDTO findById(Long id) {
        return SysRolePermissionConvert.INSTANCE.entityToBizDTO(sysRolePermissionService.getById(id));
    }

    @Override
    public List<SysRolePermissionDTO> listByIds(Collection<Long> idList) {
        return SysRolePermissionConvert.INSTANCE.entityListToBizDTOList(sysRolePermissionService.listByIds(idList));
    }

    @Override
    public int count() {
        return sysRolePermissionService.count();
    }

    @Override
    public List<SysRolePermissionDTO> list() {
        return SysRolePermissionConvert.INSTANCE.entityListToBizDTOList(sysRolePermissionService.list());
    }

    @Override
    public IPage<SysRolePermissionDTO> page(int current, int size) {
        IPage<SysRolePermission> page = sysRolePermissionService.page(Page.of(current, size));
        return page.convert(SysRolePermissionConvert.INSTANCE::entityToBizDTO);
    }

    @Override
    public List<Long> listPermIds(Long menuId, Long roleId) {
        return sysRolePermissionService.listPermIds(menuId, roleId);
    }

    @Override
    public boolean saveRolePerms(RolePermsDTO rolePermsDTO) {
        return sysRolePermissionService.saveRolePerms(rolePermsDTO);
    }


}
