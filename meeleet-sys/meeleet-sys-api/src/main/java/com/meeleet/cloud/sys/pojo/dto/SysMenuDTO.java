package com.meeleet.cloud.sys.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.meeleet.cloud.common.pojo.dto.BaseDTO;
import com.meeleet.cloud.sys.enums.MenuTypeEnum;
import lombok.Data;

import java.util.List;

/**
 * 菜单实体类
 *
 * @author jaychang
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SysMenuDTO extends BaseDTO {

    private static final long serialVersionUID = -4657378164424261965L;

    private Long id;

    private Long parentId;

    private String name;

    private String icon;

    /**
     * 路由相对路径
     */
    private String path;

    /**
     * 组件绝对路径
     */
    private String component;

    private Integer sort;

    private Integer visible;

    private String redirect;

    private List<String> roles;

    /**
     * 菜单类型(1:菜单；2：目录；3：外链)
     */
    private MenuTypeEnum type;
}
