package com.meeleet.cloud.sys.pojo.convert;

import com.meeleet.cloud.sys.pojo.dto.SysPermissionDTO;
import com.meeleet.cloud.sys.pojo.entity.SysPermission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface SysPermissionConvert {
    SysPermissionConvert INSTANCE = Mappers.getMapper(SysPermissionConvert.class);

    SysPermission bizDTOToEntity(SysPermissionDTO sysPermissionDTO);

    SysPermissionDTO entityToBizDTO(SysPermission sysPermission);

    Collection<SysPermission> bizDTOCollectionToEntityCollection(Collection<SysPermissionDTO> sysDeptDTOList);

    Collection<SysPermissionDTO> entityCollectionToBizDTOCollection(Collection<SysPermission> sysDeptList);

    List<SysPermission> bizDTOListToEntityList(List<SysPermissionDTO> sysPermissionDTOList);

    List<SysPermissionDTO> entityListToBizDTOList(List<SysPermission> sysPermissionList);
}
