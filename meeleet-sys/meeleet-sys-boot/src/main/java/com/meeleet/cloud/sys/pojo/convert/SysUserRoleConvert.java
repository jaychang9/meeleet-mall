package com.meeleet.cloud.sys.pojo.convert;

import com.meeleet.cloud.sys.pojo.dto.SysUserRoleDTO;
import com.meeleet.cloud.sys.pojo.entity.SysUserRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface SysUserRoleConvert {
    SysUserRoleConvert INSTANCE = Mappers.getMapper(SysUserRoleConvert.class);

    SysUserRole bizDTOToEntity(SysUserRoleDTO sysUserRoleDTO);

    SysUserRoleDTO entityToBizDTO(SysUserRole sysUserRole);

    Collection<SysUserRole> bizDTOCollectionToEntityCollection(Collection<SysUserRoleDTO> sysDeptDTOList);

    Collection<SysUserRoleDTO> entityCollectionToBizDTOCollection(Collection<SysUserRole> sysDeptList);

    List<SysUserRole> bizDTOListToEntityList(List<SysUserRoleDTO> sysUserRoleDTOList);

    List<SysUserRoleDTO> entityListToBizDTOList(List<SysUserRole> sysUserRoleList);
}
