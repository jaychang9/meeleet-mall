package com.meeleet.cloud.sys.rpc.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meeleet.cloud.sys.pojo.convert.SysPermissionConvert;
import com.meeleet.cloud.sys.pojo.dto.SysPermissionDTO;
import com.meeleet.cloud.sys.pojo.entity.SysPermission;
import com.meeleet.cloud.sys.pojo.query.PermissionPageQuery;
import com.meeleet.cloud.sys.pojo.vo.PermissionPageVO;
import com.meeleet.cloud.sys.rpc.ISysPermissionRpcService;
import com.meeleet.cloud.sys.service.ISysPermissionService;
import lombok.AllArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Collection;
import java.util.List;

@DubboService
@AllArgsConstructor
public class SysPermissionRpcServiceImpl implements ISysPermissionRpcService {

    private final ISysPermissionService sysPermissionService;
    
    @Override
    public boolean save(SysPermissionDTO sysPermissionDTO) {
        return sysPermissionService.save(SysPermissionConvert.INSTANCE.bizDTOToEntity(sysPermissionDTO));
    }

    @Override
    public boolean saveBatch(Collection<SysPermissionDTO> sysPermissionDTOList) {
        return sysPermissionService.saveBatch(SysPermissionConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysPermissionDTOList));
    }

    @Override
    public boolean saveBatch(Collection<SysPermissionDTO> sysPermissionDTOList, int batchSize) {
        return sysPermissionService.saveBatch(SysPermissionConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysPermissionDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysPermissionDTO> sysPermissionDTOList) {
        return sysPermissionService.saveOrUpdateBatch(SysPermissionConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysPermissionDTOList));
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysPermissionDTO> sysPermissionDTOList, int batchSize) {
        return sysPermissionService.saveOrUpdateBatch(SysPermissionConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysPermissionDTOList), batchSize);
    }

    @Override
    public boolean removeById(Long id) {
        return sysPermissionService.removeById(id);
    }

    @Override
    public boolean removeByIds(Collection<Long> idList) {
        return sysPermissionService.removeByIds(idList);
    }

    @Override
    public boolean updateById(SysPermissionDTO sysPermissionDTO) {
        return sysPermissionService.updateById(SysPermissionConvert.INSTANCE.bizDTOToEntity(sysPermissionDTO));
    }

    @Override
    public boolean updateBatchById(Collection<SysPermissionDTO> sysPermissionDTOList) {
        return sysPermissionService.updateBatchById(SysPermissionConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysPermissionDTOList));
    }

    @Override
    public boolean updateBatchById(Collection<SysPermissionDTO> sysPermissionDTOList, int batchSize) {
        return sysPermissionService.updateBatchById(SysPermissionConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysPermissionDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdate(SysPermissionDTO sysPermissionDTO) {
        return sysPermissionService.saveOrUpdate(SysPermissionConvert.INSTANCE.bizDTOToEntity(sysPermissionDTO));
    }

    @Override
    public SysPermissionDTO findById(Long id) {
        return SysPermissionConvert.INSTANCE.entityToBizDTO(sysPermissionService.getById(id));
    }

    @Override
    public List<SysPermissionDTO> listByIds(Collection<Long> idList) {
        return SysPermissionConvert.INSTANCE.entityListToBizDTOList(sysPermissionService.listByIds(idList));
    }

    @Override
    public long count() {
        return sysPermissionService.count();
    }

    @Override
    public List<SysPermissionDTO> list() {
        return SysPermissionConvert.INSTANCE.entityListToBizDTOList(sysPermissionService.list());
    }

    @Override
    public IPage<SysPermissionDTO> page(int current, int size) {
        IPage<SysPermission> page = sysPermissionService.page(Page.of(current, size));
        return page.convert(SysPermissionConvert.INSTANCE::entityToBizDTO);
    }

    @Override
    public List<SysPermissionDTO> listPermRoles() {
        List<SysPermission> sysPermissions = sysPermissionService.listPermRoles();
        return SysPermissionConvert.INSTANCE.entityListToBizDTOList(sysPermissions);
    }

    @Override
    public List<String> listBtnPermByRoles(List<String> roles) {
        return sysPermissionService.listBtnPermByRoles(roles);
    }

    @Override
    public boolean refreshPermRolesRules() {
        return sysPermissionService.refreshPermRolesRules();
    }

    @Override
    public IPage<PermissionPageVO> listPermissionsWithPage(PermissionPageQuery permissionPageQuery) {
        return sysPermissionService.listPermissionsWithPage(permissionPageQuery);
    }
}
