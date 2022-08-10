package com.meeleet.cloud.sys.pojo.vo;

import com.meeleet.cloud.common.pojo.vo.BaseVO;
import lombok.Data;

@Data
public class MenuDetailVO extends BaseVO {

    private static final long serialVersionUID = -3517936063800993589L;

    private Long id;

    private Long parentId;

    private String name;

    private String icon;

    private String routeName;

    private String routePath;

    private String component;

    private Integer sort;

    private Integer visible;

    private String redirect;

    private Integer type;

}
