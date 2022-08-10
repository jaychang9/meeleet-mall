package com.meeleet.cloud.sys.pojo.dto;

import com.meeleet.cloud.common.pojo.dto.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class SysRoleDTO extends BaseDTO {

    private static final long serialVersionUID = 8560113429131606898L;

    private Long id;

    private String name;

    @Schema(description = "角色编码")
    private String code;

    private Integer sort;

    private Integer status;

    @Schema(description = "逻辑删除标识 0-未删除 1-已删除",allowableValues = "0,1")
    //@TableLogic(value = "0", delval = "1")
    private Integer deleted;

    private List<Long> menuIds;

    private List<Long> permissionIds;

}
