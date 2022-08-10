package com.meeleet.mall.ums.pojo.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 会员认证传输层对象
 *
 * @author jaychang
 */
@Data
@Accessors(chain = true)
public class MemberAuthInfoDTO implements Serializable {

    /**
     * 会员ID
     */
    private Long memberId;

    /**
     * 会员名(openId、mobile，username)
     */
    private String username;

    /**
     * 密码（仅grant_type=password密码模式时有值）
     */
    private String password;

    /**
     * 状态(1:正常；0：禁用)
     */
    private Integer status;
}
