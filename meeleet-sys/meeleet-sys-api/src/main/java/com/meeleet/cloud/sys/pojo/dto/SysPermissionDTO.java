package com.meeleet.cloud.sys.pojo.dto;

import com.meeleet.cloud.common.pojo.dto.BaseDTO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class SysPermissionDTO extends BaseDTO {

    private static final long serialVersionUID = 4884083160905868866L;

    private Long id;

    private String name;

    private Long menuId;

    private String urlPerm;

    private String btnPerm;

    // 有权限的角色编号集合
    private List<String> roles;

}
