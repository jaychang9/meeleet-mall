package com.meeleet.mall.ums.pojo.dto;

import lombok.Data;

import java.io.Serializable;


/**
 * 会员传输层对象
 *
 * @author jaychang
 */
@Data
public class MemberInfoDTO implements Serializable {

    private String nickName;

    private String avatarUrl;

    private Long balance;

}
