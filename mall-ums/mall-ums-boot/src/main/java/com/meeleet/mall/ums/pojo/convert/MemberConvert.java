package com.meeleet.mall.ums.pojo.convert;


import com.meeleet.mall.ums.pojo.dto.MemberDTO;
import com.meeleet.mall.ums.pojo.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface MemberConvert {
    MemberConvert INSTANCE = Mappers.getMapper(MemberConvert.class);

    Member bizDTOToEntity(MemberDTO umsMemberDTO);

    MemberDTO entityToBizDTO(Member umsMember);

    Collection<Member> bizDTOCollectionToEntityCollection(Collection<MemberDTO> umsMemberDTOList);

    Collection<MemberDTO> entityCollectionToBizDTOCollection(Collection<Member> umsMemberList);

    List<Member> bizDTOListToEntityList(List<MemberDTO> umsMemberDTOList);

    List<MemberDTO> entityListToBizDTOList(List<Member> umsMemberList);
}
