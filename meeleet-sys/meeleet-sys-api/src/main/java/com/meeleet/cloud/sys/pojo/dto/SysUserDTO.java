package com.meeleet.cloud.sys.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.meeleet.cloud.common.pojo.dto.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;


@Data
public class SysUserDTO extends BaseDTO {

    private static final long serialVersionUID = -2516262950178072485L;

    private Long id;

    private String username;

    private String nickname;

    private String mobile;

    private Integer gender;

    private String avatar;

    @JsonIgnore
    private String password;

    private String email;

    private Integer status;

    private Long deptId;

    @Schema(description = "逻辑删除标识： 0-未删除 1-已删除", allowableValues = "0,1")
    private Integer deleted;

    private String deptName;

    private List<Long> roleIds;

    private String roleNames;

    private List<String> roles;

}
