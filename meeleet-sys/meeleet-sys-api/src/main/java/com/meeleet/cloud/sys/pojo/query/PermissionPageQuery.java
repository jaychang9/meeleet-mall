package com.meeleet.cloud.sys.pojo.query;

import com.meeleet.cloud.common.pojo.query.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 权限分页查询对象
 *
 * @author jaychang
 */
@Data
public class PermissionPageQuery extends BasePageQuery {

    @Schema(description = "权限名称")
    private String name;

    @Schema(description = "菜单ID")
    private Long menuId;

}
