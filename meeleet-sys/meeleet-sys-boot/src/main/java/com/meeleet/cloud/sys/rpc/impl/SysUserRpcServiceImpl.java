package com.meeleet.cloud.sys.rpc.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meeleet.cloud.sys.pojo.convert.SysUserConvert;
import com.meeleet.cloud.sys.pojo.dto.AuthUserDTO;
import com.meeleet.cloud.sys.pojo.dto.SysUserDTO;
import com.meeleet.cloud.sys.pojo.dto.UserDTO;
import com.meeleet.cloud.sys.pojo.entity.SysUser;
import com.meeleet.cloud.sys.pojo.query.UserPageQuery;
import com.meeleet.cloud.sys.pojo.vo.UserDetailVO;
import com.meeleet.cloud.sys.pojo.vo.UserExportVO;
import com.meeleet.cloud.sys.pojo.vo.UserPageVO;
import com.meeleet.cloud.sys.rpc.ISysUserRpcService;
import com.meeleet.cloud.sys.service.ISysUserService;
import lombok.AllArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Collection;
import java.util.List;

@DubboService
@AllArgsConstructor
public class SysUserRpcServiceImpl implements ISysUserRpcService {

    private final ISysUserService sysUserService;

    @Override
    public boolean save(SysUserDTO sysUserDTO) {
        return sysUserService.save(SysUserConvert.INSTANCE.bizDTOToEntity(sysUserDTO));
    }

    @Override
    public boolean saveBatch(Collection<SysUserDTO> sysUserDTOList) {
        return sysUserService.saveBatch(SysUserConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysUserDTOList));
    }

    @Override
    public boolean saveBatch(Collection<SysUserDTO> sysUserDTOList, int batchSize) {
        return sysUserService.saveBatch(SysUserConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysUserDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysUserDTO> sysUserDTOList) {
        return sysUserService.saveOrUpdateBatch(SysUserConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysUserDTOList));
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysUserDTO> sysUserDTOList, int batchSize) {
        return sysUserService.saveOrUpdateBatch(SysUserConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysUserDTOList), batchSize);
    }

    @Override
    public boolean removeById(Long id) {
        return sysUserService.removeById(id);
    }

    @Override
    public boolean removeByIds(Collection<Long> idList) {
        return sysUserService.removeByIds(idList);
    }

    @Override
    public boolean updateById(SysUserDTO sysUserDTO) {
        return sysUserService.updateById(SysUserConvert.INSTANCE.bizDTOToEntity(sysUserDTO));
    }

    @Override
    public boolean updateBatchById(Collection<SysUserDTO> sysUserDTOList) {
        return sysUserService.updateBatchById(SysUserConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysUserDTOList));
    }

    @Override
    public boolean updateBatchById(Collection<SysUserDTO> sysUserDTOList, int batchSize) {
        return sysUserService.updateBatchById(SysUserConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysUserDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdate(SysUserDTO sysUserDTO) {
        return sysUserService.saveOrUpdate(SysUserConvert.INSTANCE.bizDTOToEntity(sysUserDTO));
    }

    @Override
    public SysUserDTO findById(Long id) {
        return SysUserConvert.INSTANCE.entityToBizDTO(sysUserService.getById(id));
    }

    @Override
    public List<SysUserDTO> listByIds(Collection<Long> idList) {
        return SysUserConvert.INSTANCE.entityListToBizDTOList(sysUserService.listByIds(idList));
    }

    @Override
    public int count() {
        return sysUserService.count();
    }

    @Override
    public List<SysUserDTO> list() {
        return SysUserConvert.INSTANCE.entityListToBizDTOList(sysUserService.list());
    }

    @Override
    public IPage<SysUserDTO> page(int current, int size) {
        IPage<SysUser> page = sysUserService.page(Page.of(current, size));
        return page.convert(SysUserConvert.INSTANCE::entityToBizDTO);
    }

    @Override
    public IPage<UserPageVO> listUsersPage(UserPageQuery queryParams) {
        return sysUserService.listUsersPage(queryParams);
    }

    @Override
    public boolean saveUser(UserDTO userDTO) {
        return sysUserService.saveUser(userDTO);
    }

    @Override
    public boolean updateUser(Long userId, UserDTO userDTO) {
        return sysUserService.updateUser(userId,userDTO);
    }
    @Override
    public AuthUserDTO findAuthInfoByUsername(String username) {
        return sysUserService.getAuthInfoByUsername(username);
    }

    @Override
    public AuthUserDTO findAuthInfoByMobile(String mobile) {
        return sysUserService.getAuthInfoByMobile(mobile);
    }

    @Override
    public UserDetailVO findUserDetail(Long userId) {
        return sysUserService.getUserDetail(userId);
    }

    @Override
    public List<UserExportVO> listExportUsers(UserPageQuery queryParams) {
        return sysUserService.listExportUsers(queryParams);
    }
}
