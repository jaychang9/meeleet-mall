package com.meeleet.cloud.sys.pojo.convert;

import com.meeleet.cloud.sys.pojo.dto.SysRoleDTO;
import com.meeleet.cloud.sys.pojo.entity.SysRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface SysRoleConvert {
    SysRoleConvert INSTANCE = Mappers.getMapper(SysRoleConvert.class);

    SysRole bizDTOToEntity(SysRoleDTO sysRoleDTO);

    SysRoleDTO entityToBizDTO(SysRole sysRole);

    Collection<SysRole> bizDTOCollectionToEntityCollection(Collection<SysRoleDTO> sysDeptDTOList);

    Collection<SysRoleDTO> entityCollectionToBizDTOCollection(Collection<SysRole> sysDeptList);

    List<SysRole> bizDTOListToEntityList(List<SysRoleDTO> sysRoleDTOList);

    List<SysRoleDTO> entityListToBizDTOList(List<SysRole> sysRoleList);
}
