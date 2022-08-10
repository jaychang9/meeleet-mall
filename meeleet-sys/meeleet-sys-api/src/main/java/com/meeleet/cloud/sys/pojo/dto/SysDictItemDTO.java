package com.meeleet.cloud.sys.pojo.dto;

import com.meeleet.cloud.common.pojo.dto.BaseDTO;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SysDictItemDTO extends BaseDTO {

    private static final long serialVersionUID = -3971478304255842323L;

    private Long id;

    private String name;

    private String value;

    private String dictCode;

    private Integer sort;

    private Integer status;

    private Integer defaulted;

    private String remark;

}
