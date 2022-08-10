package com.meeleet.cloud.sys.pojo.convert;

import com.meeleet.cloud.sys.pojo.dto.SysRoleMenuDTO;
import com.meeleet.cloud.sys.pojo.entity.SysRoleMenu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface SysRoleMenuConvert {
    SysRoleMenuConvert INSTANCE = Mappers.getMapper(SysRoleMenuConvert.class);

    SysRoleMenu bizDTOToEntity(SysRoleMenuDTO sysRoleMenuDTO);

    SysRoleMenuDTO entityToBizDTO(SysRoleMenu sysRoleMenu);

    Collection<SysRoleMenu> bizDTOCollectionToEntityCollection(Collection<SysRoleMenuDTO> sysDeptDTOList);

    Collection<SysRoleMenuDTO> entityCollectionToBizDTOCollection(Collection<SysRoleMenu> sysDeptList);

    List<SysRoleMenu> bizDTOListToEntityList(List<SysRoleMenuDTO> sysRoleMenuDTOList);

    List<SysRoleMenuDTO> entityListToBizDTOList(List<SysRoleMenu> sysRoleMenuList);
}
