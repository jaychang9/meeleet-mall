package com.meeleet.cloud.sys.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class SysUserRoleDTO implements Serializable {

    private static final long serialVersionUID = -2866140919883367941L;

    private Long userId;

    private Long roleId;

}
