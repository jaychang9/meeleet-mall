package com.meeleet.cloud.sys.pojo.dto;

import lombok.Data;

import java.util.List;

/**
 * 用户表单对象
 *
 * @author jaychang
 */
@Data
public class UserDTO {

    private Long id;

    private String username;

    private String nickname;

    private String mobile;

    private Integer gender;

    private String avatar;

    private String password;

    private String email;

    private Integer status;

    private Long deptId;

    private List<Long> roleIds;


}
