package com.meeleet.cloud.sys.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.meeleet.cloud.common.pojo.entity.BaseEntity;
import com.meeleet.cloud.sys.enums.MenuTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 菜单实体类
 *
 * @author jaychang
 */
@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SysMenu extends BaseEntity {

    @TableId(type = IdType.AUTO)
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

    @TableField(exist = false)
    private List<String> roles;

    /**
     * 菜单类型(1:菜单；2：目录；3：外链)
     */
    private MenuTypeEnum type;

}
