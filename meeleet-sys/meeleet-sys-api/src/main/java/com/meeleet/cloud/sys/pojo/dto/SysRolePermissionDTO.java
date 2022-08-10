package com.meeleet.cloud.sys.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class SysRolePermissionDTO implements Serializable {

    private static final long serialVersionUID = -7699083730364478511L;

    private Long roleId;
    private Long permissionId;
}
