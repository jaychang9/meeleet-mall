package com.meeleet.mall.ums.pojo.convert;

import com.meeleet.mall.ums.pojo.dto.MemberAddressDTO;
import com.meeleet.mall.ums.pojo.entity.MemberAddress;
import org.apache.ibatis.annotations.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface MemberAddressConvert {
    MemberAddressConvert INSTANCE = Mappers.getMapper(MemberAddressConvert.class);

    MemberAddress bizDTOToEntity(MemberAddressDTO umsAddressDTO);

    MemberAddressDTO entityToBizDTO(MemberAddress umsAddress);

    Collection<MemberAddress> bizDTOCollectionToEntityCollection(Collection<MemberAddressDTO> umsAddressDTOList);

    Collection<MemberAddressDTO> entityCollectionToBizDTOCollection(Collection<MemberAddress> umsAddressList);

    List<MemberAddress> bizDTOListToEntityList(List<MemberAddressDTO> umsAddressDTOList);

    List<MemberAddressDTO> entityListToBizDTOList(List<MemberAddress> umsAddressList);
}
