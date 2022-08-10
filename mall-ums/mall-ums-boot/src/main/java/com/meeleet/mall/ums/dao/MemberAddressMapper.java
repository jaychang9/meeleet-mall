package com.meeleet.mall.ums.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.meeleet.mall.ums.pojo.entity.MemberAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberAddressMapper extends BaseMapper<MemberAddress> {

    @Select("<script>" +
            " SELECT * from ums_address where member_id =#{userId} " +
            "</script>")
    List<MemberAddress> listByUserId(Long userId);

}
