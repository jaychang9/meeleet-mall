package com.meeleet.mall.ums.pojo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.meeleet.cloud.common.pojo.entity.BaseEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * @author jaychang
 */
@Data
@TableName("member")
public class Member extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Integer gender;

    private String nickname;

    private String username;

    private String password;

    private String mobile;

    private LocalDate birthday;

    private String avatarUrl;

    private String openid;

    private String sessionKey;

    private String city;

    private String country;

    private String language;

    private String province;

    private Integer status;

    private Long balance;

    @TableField(exist = false)
    private List<MemberAddress> addressList;

    private Integer point;

}
