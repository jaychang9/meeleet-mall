package com.meeleet.cloud.sys.pojo.convert;

import com.meeleet.cloud.sys.pojo.dto.SysDictDTO;
import com.meeleet.cloud.sys.pojo.entity.SysDict;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface SysDictConvert {
    SysDictConvert INSTANCE = Mappers.getMapper(SysDictConvert.class);

    SysDict bizDTOToEntity(SysDictDTO sysDictDTO);

    SysDictDTO entityToBizDTO(SysDict sysDict);

    Collection<SysDict> bizDTOCollectionToEntityCollection(Collection<SysDictDTO> sysDictDTOList);

    Collection<SysDictDTO> entityCollectionToBizDTOCollection(Collection<SysDict> sysDictList);

    List<SysDict> bizDTOListToEntityList(List<SysDictDTO> sysDictDTOList);

    List<SysDictDTO> entityListToBizDTOList(List<SysDict> sysDictList);
}
