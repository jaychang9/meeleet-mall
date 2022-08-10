package com.meeleet.cloud.sys.pojo.query;

import com.meeleet.cloud.common.pojo.query.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用户分页查询对象
 *
 * @author jaychang
 */
@Data
public class UserPageQuery extends BasePageQuery {

    @Schema(description = "关键字(用户名、昵称、手机号)")
    private String keywords;

    @Schema(description = "用户状态")
    private Integer status;

    @Schema(description = "部门ID")
    private Long deptId;

}
