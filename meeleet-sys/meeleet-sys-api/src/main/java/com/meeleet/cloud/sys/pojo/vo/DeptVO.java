package com.meeleet.cloud.sys.pojo.vo;

import com.meeleet.cloud.common.pojo.vo.BaseVO;
import lombok.Data;

import java.util.List;

@Data
public class DeptVO extends BaseVO {

    private static final long serialVersionUID = 7455379495403844768L;

    private Long id;

    private Long parentId;

    private String name;

    private String treePath;

    private Integer sort;

    private Integer status;

    private String leader;

    private String mobile;

    private String email;

    private List<DeptVO> children;

}
