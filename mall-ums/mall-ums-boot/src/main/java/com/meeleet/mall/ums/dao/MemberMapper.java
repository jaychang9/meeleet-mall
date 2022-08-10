package com.meeleet.mall.ums.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meeleet.mall.ums.pojo.entity.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface MemberMapper extends BaseMapper<Member> {

    @Select("<script>" +
            " SELECT * from ums_member " +
            " <if test ='nickname !=null and nickname.trim() neq \"\" ' >" +
            "       WHERE nick_name like concat('%',#{nickname},'%')" +
            " </if>" +
            " ORDER BY update_time DESC, create_time DESC" +
            "</script>")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "addressList", column = "id", many = @Many(select = "com.meeleet.mall.ums.dao.MemberAddressMapper.listByUserId"))
    })
    List<Member> list(Page<Member> page, String nickname);


}
