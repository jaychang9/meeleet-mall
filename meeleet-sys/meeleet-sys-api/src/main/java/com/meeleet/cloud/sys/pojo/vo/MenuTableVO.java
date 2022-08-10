package com.meeleet.cloud.sys.pojo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.meeleet.cloud.common.pojo.vo.BaseVO;
import lombok.Data;

import java.util.List;

@Data
public class MenuTableVO extends BaseVO {

    private static final long serialVersionUID = 8831987616513834246L;

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

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private List<MenuTableVO> children;

}
