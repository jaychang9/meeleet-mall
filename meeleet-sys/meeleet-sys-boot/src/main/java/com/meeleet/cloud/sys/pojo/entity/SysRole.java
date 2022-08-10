package com.meeleet.cloud.sys.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.meeleet.cloud.common.pojo.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class SysRole extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    /**
     * 角色编码
     */
    private String code;

    private Integer sort;

    private Integer status;

    /**
     * 逻辑删除标识 0-未删除 1-已删除
     */
    //@TableLogic(value = "0", delval = "1")
    @TableField("is_deleted")
    private Integer deleted;

    @TableField(exist = false)
    private List<Long> menuIds;

    @TableField(exist = false)
    private List<Long> permissionIds;

}
