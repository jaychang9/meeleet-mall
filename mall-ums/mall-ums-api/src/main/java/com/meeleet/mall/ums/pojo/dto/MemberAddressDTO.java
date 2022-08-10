package com.meeleet.mall.ums.pojo.dto;

import com.meeleet.cloud.common.pojo.dto.BaseDTO;
import lombok.Data;

/**
 * @author jaychang
 */
@Data
public class MemberAddressDTO extends BaseDTO {

    private Long id;

    /**
     * 会员ID
     */
    private Long memberId;

    /**
     * 收货人姓名
     */
    private String consigneeName;

    /**
     * 收货人联系方式
     */
    private String consigneeMobile;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String area;

    /**
     * 详细地址
     */
    private String detailAddress;

    /**
     * 邮编
     */
    private String zipCode;

    /**
     * 是否默认地址(1:是；0:否)
     */
    private Integer defaulted;

}
