package com.meeleet.cloud.sys.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.meeleet.cloud.common.pojo.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SysDictItem extends BaseEntity {

    @TableId(type= IdType.AUTO)
    private Long id;

    private String name;

    private String value;

    private String dictCode;

    private Integer sort;

    private Integer status;

    @TableField("is_default")
    private Integer defaulted;

    private String remark;

}
