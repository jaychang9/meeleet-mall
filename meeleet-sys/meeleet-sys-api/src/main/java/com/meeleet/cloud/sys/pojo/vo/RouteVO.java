package com.meeleet.cloud.sys.pojo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.meeleet.cloud.common.pojo.vo.BaseVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author jaychang
 * @date 2020-11-06
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RouteVO extends BaseVO {

    private static final long serialVersionUID = 4019862636175799744L;

    private String path;

    private String component;

    private String redirect;

    /**
     * 如果设置为 true
     */
    private Boolean alwaysShow;

    private String name;

    private Boolean hidden;

    private Meta meta;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Meta {
        private String title;
        private String icon;
        private List<String> roles;
    }
    private List<RouteVO> children;
}
