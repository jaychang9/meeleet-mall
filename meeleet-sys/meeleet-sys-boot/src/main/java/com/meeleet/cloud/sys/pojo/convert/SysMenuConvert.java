package com.meeleet.cloud.sys.pojo.convert;

import com.meeleet.cloud.sys.pojo.dto.SysMenuDTO;
import com.meeleet.cloud.sys.pojo.entity.SysMenu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface SysMenuConvert {
    SysMenuConvert INSTANCE = Mappers.getMapper(SysMenuConvert.class);

    SysMenu bizDTOToEntity(SysMenuDTO sysMenuDTO);

    SysMenuDTO entityToBizDTO(SysMenu sysMenu);

    Collection<SysMenu> bizDTOCollectionToEntityCollection(Collection<SysMenuDTO> sysDeptDTOList);

    Collection<SysMenuDTO> entityCollectionToBizDTOCollection(Collection<SysMenu> sysDeptList);

    List<SysMenu> bizDTOListToEntityList(List<SysMenuDTO> sysMenuDTOList);

    List<SysMenuDTO> entityListToBizDTOList(List<SysMenu> sysMenuList);
}
