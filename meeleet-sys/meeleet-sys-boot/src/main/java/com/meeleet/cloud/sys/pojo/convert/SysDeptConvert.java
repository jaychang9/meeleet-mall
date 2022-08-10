package com.meeleet.cloud.sys.pojo.convert;

import com.meeleet.cloud.sys.pojo.dto.SysDeptDTO;
import com.meeleet.cloud.sys.pojo.entity.SysDept;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface SysDeptConvert {
    SysDeptConvert INSTANCE = Mappers.getMapper(SysDeptConvert.class);

    SysDept bizDTOToEntity(SysDeptDTO sysDeptDTO);

    SysDeptDTO entityToBizDTO(SysDept sysDept);

    Collection<SysDept> bizDTOCollectionToEntityCollection(Collection<SysDeptDTO> sysDeptDTOList);

    Collection<SysDeptDTO> entityCollectionToBizDTOCollection(Collection<SysDept> sysDeptList);

    List<SysDept> bizDTOListToEntityList(List<SysDeptDTO> sysDeptDTOList);

    List<SysDeptDTO> entityListToBizDTOList(List<SysDept> sysDeptList);
}
