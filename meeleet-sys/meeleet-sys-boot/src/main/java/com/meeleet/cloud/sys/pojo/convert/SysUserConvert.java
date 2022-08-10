package com.meeleet.cloud.sys.pojo.convert;

import com.meeleet.cloud.sys.pojo.dto.SysUserDTO;
import com.meeleet.cloud.sys.pojo.entity.SysUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface SysUserConvert {
    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    SysUser bizDTOToEntity(SysUserDTO sysUserDTO);

    SysUserDTO entityToBizDTO(SysUser sysUser);

    Collection<SysUser> bizDTOCollectionToEntityCollection(Collection<SysUserDTO> sysDeptDTOList);

    Collection<SysUserDTO> entityCollectionToBizDTOCollection(Collection<SysUser> sysDeptList);

    List<SysUser> bizDTOListToEntityList(List<SysUserDTO> sysUserDTOList);

    List<SysUserDTO> entityListToBizDTOList(List<SysUser> sysUserList);
}
