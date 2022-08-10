package com.meeleet.mall.ums.pojo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 会员视图层对象
 *
 * @author jaychang
 */
@Schema(description = "会员视图层对象")
@Data
public class MemberVO implements Serializable {

    private static final long serialVersionUID = -2669117449383683822L;

    @Schema(description = "会员ID")
    private Long id;

    @Schema(description = "会员昵称")
    private String nickName;

    @Schema(description = "会员头像地址")
    private String avatarUrl;

    @Schema(description = "会员手机号")
    private String mobile;

    @Schema(description = "会员余额(单位:分)")
    private Long balance;

}
