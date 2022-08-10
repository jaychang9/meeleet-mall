package com.meeleet.cloud.sys.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 客户端实体
 */
@Data
public class SysOauthClientDTO implements Serializable {

    private static final long serialVersionUID = -897964942199589840L;

    @Schema(description = "客户端ID")
    private String clientId;

    @Schema(description = "客户端密钥")
    private String clientSecret;

    @Schema(description = "资源id列表")
    private String resourceIds;

    @Schema(description = "域")
    private String scope;

    @Schema(description = "授权方式")
    private String authorizedGrantTypes;

    @Schema(description = "回调地址")
    private String webServerRedirectUri;

    @Schema(description = "权限列表")
    private String authorities;

    @Schema(description = "认证令牌时效")
    private Integer accessTokenValidity;

    @Schema(description = "刷新令牌时效")
    private Integer refreshTokenValidity;

    @Schema(description = "扩展信息")
    private String additionalInformation;

    @Schema(description = "是否自动放行")
    private String autoapprove;

}
