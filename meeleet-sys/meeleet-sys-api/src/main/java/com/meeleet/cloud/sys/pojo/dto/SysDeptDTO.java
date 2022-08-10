package com.meeleet.cloud.sys.pojo.dto;

import com.meeleet.cloud.common.pojo.dto.BaseDTO;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SysDeptDTO extends BaseDTO {

    private static final long serialVersionUID = -7922272650060197500L;

    private Long id;

    private String name;

    private Long parentId;

    private String treePath;

    private Integer sort;

    private Integer status;

    private Integer deleted;

}
