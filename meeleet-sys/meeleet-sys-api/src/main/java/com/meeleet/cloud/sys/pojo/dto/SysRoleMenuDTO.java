package com.meeleet.cloud.sys.pojo.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class SysRoleMenuDTO implements Serializable {

    private static final long serialVersionUID = -8607436276644186092L;

    private Long roleId;

    private Long menuId;

}
