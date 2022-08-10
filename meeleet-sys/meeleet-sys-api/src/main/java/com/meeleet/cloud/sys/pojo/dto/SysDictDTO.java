package com.meeleet.cloud.sys.pojo.dto;

import com.meeleet.cloud.common.pojo.dto.BaseDTO;
import lombok.Data;

@Data
public class SysDictDTO extends BaseDTO {

    private static final long serialVersionUID = -3646690109646751710L;

    private Long id;

    private String code;

    private String name;

    private Integer status;

    private  String  remark;

}
