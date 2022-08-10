package com.meeleet.cloud.sys.pojo.convert;

import com.meeleet.cloud.sys.pojo.dto.SysOauthClientDTO;
import com.meeleet.cloud.sys.pojo.entity.SysOauthClient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface SysOauthClientConvert {
    SysOauthClientConvert INSTANCE = Mappers.getMapper(SysOauthClientConvert.class);

    SysOauthClient bizDTOToEntity(SysOauthClientDTO sysOauthClientDTO);

    SysOauthClientDTO entityToBizDTO(SysOauthClient sysOauthClient);

    Collection<SysOauthClient> bizDTOCollectionToEntityCollection(Collection<SysOauthClientDTO> sysDeptDTOList);

    Collection<SysOauthClientDTO> entityCollectionToBizDTOCollection(Collection<SysOauthClient> sysDeptList);

    List<SysOauthClient> bizDTOListToEntityList(List<SysOauthClientDTO> sysOauthClientDTOList);

    List<SysOauthClientDTO> entityListToBizDTOList(List<SysOauthClient> sysOauthClientList);
}
