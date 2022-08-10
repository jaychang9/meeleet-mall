package com.meeleet.cloud.sys.pojo.convert;

import com.meeleet.cloud.sys.pojo.dto.SysDictItemDTO;
import com.meeleet.cloud.sys.pojo.entity.SysDictItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface SysDictItemConvert {
    SysDictItemConvert INSTANCE = Mappers.getMapper(SysDictItemConvert.class);

    SysDictItem bizDTOToEntity(SysDictItemDTO sysDictItemDTO);

    SysDictItemDTO entityToBizDTO(SysDictItem sysDictItem);

    Collection<SysDictItem> bizDTOCollectionToEntityCollection(Collection<SysDictItemDTO> sysDeptDTOList);

    Collection<SysDictItemDTO> entityCollectionToBizDTOCollection(Collection<SysDictItem> sysDeptList);

    List<SysDictItem> bizDTOToEntityList(List<SysDictItemDTO> sysDictItemDTOList);

    List<SysDictItemDTO> entityListToBizDTOList(List<SysDictItem> sysDictItemList);
}
