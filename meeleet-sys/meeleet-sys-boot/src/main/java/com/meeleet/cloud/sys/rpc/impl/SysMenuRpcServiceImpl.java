package com.meeleet.cloud.sys.rpc.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meeleet.cloud.common.pojo.vo.OptionVO;
import com.meeleet.cloud.sys.pojo.convert.SysMenuConvert;
import com.meeleet.cloud.sys.pojo.dto.SysMenuDTO;
import com.meeleet.cloud.sys.pojo.entity.SysMenu;
import com.meeleet.cloud.sys.pojo.vo.MenuTableVO;
import com.meeleet.cloud.sys.pojo.vo.NextRouteVO;
import com.meeleet.cloud.sys.rpc.ISysMenuRpcService;
import com.meeleet.cloud.sys.service.ISysMenuService;
import lombok.AllArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.cache.annotation.CacheEvict;

import java.util.Collection;
import java.util.List;

@DubboService
@AllArgsConstructor
public class SysMenuRpcServiceImpl implements ISysMenuRpcService {

    private final ISysMenuService sysMenuService;

    @Override
    public boolean save(SysMenuDTO sysMenuDTO) {
        return sysMenuService.save(SysMenuConvert.INSTANCE.bizDTOToEntity(sysMenuDTO));
    }

    @Override
    public boolean saveBatch(Collection<SysMenuDTO> sysMenuDTOList) {
        return sysMenuService.saveBatch(SysMenuConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysMenuDTOList));
    }

    @Override
    public boolean saveBatch(Collection<SysMenuDTO> sysMenuDTOList, int batchSize) {
        return sysMenuService.saveBatch(SysMenuConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysMenuDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysMenuDTO> sysMenuDTOList) {
        return sysMenuService.saveOrUpdateBatch(SysMenuConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysMenuDTOList));
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysMenuDTO> sysMenuDTOList, int batchSize) {
        return sysMenuService.saveOrUpdateBatch(SysMenuConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysMenuDTOList), batchSize);
    }

    @Override
    public boolean removeById(Long id) {
        return sysMenuService.removeById(id);
    }

    @Override
    public boolean removeByIds(Collection<Long> idList) {
        return sysMenuService.removeByIds(idList);
    }

    @Override
    public boolean updateById(SysMenuDTO sysMenuDTO) {
        return sysMenuService.updateById(SysMenuConvert.INSTANCE.bizDTOToEntity(sysMenuDTO));
    }

    @Override
    public boolean updateBatchById(Collection<SysMenuDTO> sysMenuDTOList) {
        return sysMenuService.updateBatchById(SysMenuConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysMenuDTOList));
    }

    @Override
    public boolean updateBatchById(Collection<SysMenuDTO> sysMenuDTOList, int batchSize) {
        return sysMenuService.updateBatchById(SysMenuConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysMenuDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdate(SysMenuDTO sysMenuDTO) {
        return sysMenuService.saveOrUpdate(SysMenuConvert.INSTANCE.bizDTOToEntity(sysMenuDTO));
    }

    @Override
    public SysMenuDTO findById(Long id) {
        return SysMenuConvert.INSTANCE.entityToBizDTO(sysMenuService.getById(id));
    }

    @Override
    public List<SysMenuDTO> listByIds(Collection<Long> idList) {
        return SysMenuConvert.INSTANCE.entityListToBizDTOList(sysMenuService.listByIds(idList));
    }

    @Override
    public int count() {
        return sysMenuService.count();
    }

    @Override
    public List<SysMenuDTO> list() {
        return SysMenuConvert.INSTANCE.entityListToBizDTOList(sysMenuService.list());
    }

    @Override
    public IPage<SysMenuDTO> page(int current, int size) {
        IPage<SysMenu> page = sysMenuService.page(Page.of(current, size));
        return page.convert(SysMenuConvert.INSTANCE::entityToBizDTO);
    }

    @Override
    public List<MenuTableVO> listTableMenus(String name) {
        return sysMenuService.listTableMenus(name);
    }

    @Override
    public List<OptionVO> listSelectMenus() {
        return sysMenuService.listSelectMenus();
    }

    @Override
    public boolean saveMenu(SysMenuDTO menu) {
        SysMenu sysMenu = SysMenuConvert.INSTANCE.bizDTOToEntity(menu);
        return sysMenuService.saveMenu(sysMenu);
    }

    @Override
    public boolean updateMenu(SysMenuDTO menu) {
        SysMenu sysMenu = SysMenuConvert.INSTANCE.bizDTOToEntity(menu);
        return sysMenuService.updateMenu(sysMenu);
    }

    /**
     * 清理路由缓存
     */
    @Override
    @CacheEvict(cacheNames = "system", key = "'routes'")
    public void cleanCache() {
    }


    @Override
    public List<NextRouteVO> listNextRoutes() {
        return sysMenuService.listNextRoutes();
    }
}
