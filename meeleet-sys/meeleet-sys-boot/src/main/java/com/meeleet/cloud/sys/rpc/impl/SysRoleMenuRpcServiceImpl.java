package com.meeleet.cloud.sys.rpc.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meeleet.cloud.sys.pojo.convert.SysRoleMenuConvert;
import com.meeleet.cloud.sys.pojo.dto.SysRoleMenuDTO;
import com.meeleet.cloud.sys.pojo.entity.SysRoleMenu;
import com.meeleet.cloud.sys.rpc.ISysRoleMenuRpcService;
import com.meeleet.cloud.sys.service.ISysRoleMenuService;
import lombok.AllArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Collection;
import java.util.List;

@DubboService
@AllArgsConstructor
public class SysRoleMenuRpcServiceImpl implements ISysRoleMenuRpcService {
    private final ISysRoleMenuService sysRoleMenuService;

    @Override
    public boolean save(SysRoleMenuDTO sysRoleMenuDTO) {
        return sysRoleMenuService.save(SysRoleMenuConvert.INSTANCE.bizDTOToEntity(sysRoleMenuDTO));
    }

    @Override
    public boolean saveBatch(Collection<SysRoleMenuDTO> sysRoleMenuDTOList) {
        return sysRoleMenuService.saveBatch(SysRoleMenuConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysRoleMenuDTOList));
    }

    @Override
    public boolean saveBatch(Collection<SysRoleMenuDTO> sysRoleMenuDTOList, int batchSize) {
        return sysRoleMenuService.saveBatch(SysRoleMenuConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysRoleMenuDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysRoleMenuDTO> sysRoleMenuDTOList) {
        return sysRoleMenuService.saveOrUpdateBatch(SysRoleMenuConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysRoleMenuDTOList));
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysRoleMenuDTO> sysRoleMenuDTOList, int batchSize) {
        return sysRoleMenuService.saveOrUpdateBatch(SysRoleMenuConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysRoleMenuDTOList), batchSize);
    }

    @Override
    public boolean removeById(Long id) {
        return sysRoleMenuService.removeById(id);
    }

    @Override
    public boolean removeByIds(Collection<Long> idList) {
        return sysRoleMenuService.removeByIds(idList);
    }

    @Override
    public boolean updateById(SysRoleMenuDTO sysRoleMenuDTO) {
        return sysRoleMenuService.updateById(SysRoleMenuConvert.INSTANCE.bizDTOToEntity(sysRoleMenuDTO));
    }

    @Override
    public boolean updateBatchById(Collection<SysRoleMenuDTO> sysRoleMenuDTOList) {
        return sysRoleMenuService.updateBatchById(SysRoleMenuConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysRoleMenuDTOList));
    }

    @Override
    public boolean updateBatchById(Collection<SysRoleMenuDTO> sysRoleMenuDTOList, int batchSize) {
        return sysRoleMenuService.updateBatchById(SysRoleMenuConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysRoleMenuDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdate(SysRoleMenuDTO sysRoleMenuDTO) {
        return sysRoleMenuService.saveOrUpdate(SysRoleMenuConvert.INSTANCE.bizDTOToEntity(sysRoleMenuDTO));
    }

    @Override
    public SysRoleMenuDTO findById(Long id) {
        return SysRoleMenuConvert.INSTANCE.entityToBizDTO(sysRoleMenuService.getById(id));
    }

    @Override
    public List<SysRoleMenuDTO> listByIds(Collection<Long> idList) {
        return SysRoleMenuConvert.INSTANCE.entityListToBizDTOList(sysRoleMenuService.listByIds(idList));
    }

    @Override
    public long count() {
        return sysRoleMenuService.count();
    }

    @Override
    public List<SysRoleMenuDTO> list() {
        return SysRoleMenuConvert.INSTANCE.entityListToBizDTOList(sysRoleMenuService.list());
    }

    @Override
    public IPage<SysRoleMenuDTO> page(int current, int size) {
        IPage<SysRoleMenu> page = sysRoleMenuService.page(Page.of(current, size));
        return page.convert(SysRoleMenuConvert.INSTANCE::entityToBizDTO);
    }

    @Override
    public List<Long> listMenuIds(Long roleId) {
        return sysRoleMenuService.listMenuIds(roleId);
    }

    @Override
    public boolean update(Long roleId, List<Long> menuIds) {
        return sysRoleMenuService.update(roleId, menuIds);
    }
}
