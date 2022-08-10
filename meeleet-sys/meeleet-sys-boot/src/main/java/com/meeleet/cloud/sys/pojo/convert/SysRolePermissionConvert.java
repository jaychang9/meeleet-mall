package com.meeleet.cloud.sys.pojo.convert;

import com.meeleet.cloud.sys.pojo.dto.SysRolePermissionDTO;
import com.meeleet.cloud.sys.pojo.entity.SysRolePermission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface SysRolePermissionConvert {
    SysRolePermissionConvert INSTANCE = Mappers.getMapper(SysRolePermissionConvert.class);

    SysRolePermission bizDTOToEntity(SysRolePermissionDTO sysRolePermissionDTO);

    SysRolePermissionDTO entityToBizDTO(SysRolePermission sysRolePermission);

    Collection<SysRolePermission> bizDTOCollectionToEntityCollection(Collection<SysRolePermissionDTO> sysDeptDTOList);

    Collection<SysRolePermissionDTO> entityCollectionToBizDTOCollection(Collection<SysRolePermission> sysDeptList);

    List<SysRolePermission> bizDTOListToEntityList(List<SysRolePermissionDTO> sysRolePermissionDTOList);

    List<SysRolePermissionDTO> entityListToBizDTOList(List<SysRolePermission> sysRolePermissionList);

}
