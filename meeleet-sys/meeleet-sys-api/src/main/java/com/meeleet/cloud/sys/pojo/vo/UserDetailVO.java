package com.meeleet.cloud.sys.pojo.vo;

import com.meeleet.cloud.common.pojo.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * 用户详情视图对象
 *
 * @author jaychang
 */
@Schema(description = "用户详情视图对象")
@Data
public class UserDetailVO extends BaseVO {

    private static final long serialVersionUID = 2215682698051108919L;

    @Schema(description = "用户ID")
    private Long id;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "用户昵称")
    private String nickname;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "性别(1:男;2:女)")
    private Integer gender;

    @Schema(description = "用户头像")
    private String avatar;

    @Schema(description = "用户邮箱")
    private String email;

    @Schema(description = "用户状态(1:启用;0:禁用)")
    private Integer status;

    @Schema(description = "部门ID")
    private Long deptId;

    @Schema(description = "用户角色ID的集合")
    private List<Long> roleIds;

}
