package com.meeleet.cloud.sys.pojo.vo;

import com.meeleet.cloud.common.pojo.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 权限视图对象
 *
 * @author jaychang
 */
@Data
@Schema(description = "权限视图对象")
public class PermissionPageVO extends BaseVO {

    private static final long serialVersionUID = -5943617285403370234L;

    @Schema(description = "权限ID")
    private Long id;

    @Schema(description = "权限名称")
    private String name;

    @Schema(description = "URL权限标识-服务名称")
    private String serviceName;

    @Schema(description = "URL权限标识-请求标识")
    private String requestMethod;

    @Schema(description = "URL权限标识-请求方式")
    private String requestPath;

    @Schema(description = "按钮权限标识")
    private String btnPerm;

}
