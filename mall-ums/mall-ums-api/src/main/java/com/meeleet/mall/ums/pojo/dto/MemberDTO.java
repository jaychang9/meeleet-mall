package com.meeleet.mall.ums.pojo.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;


/**
 * 会员传输层对象
 *
 * @author jaychang
 */
@Data
public class MemberDTO implements Serializable {

    private static final long serialVersionUID = -7945696836842786811L;

    private Integer gender;

    private String nickname;

    private String username;

    private String password;

    private String mobile;

    private LocalDate birthday;

    private String avatarUrl;

    private String openid;

    private String sessionKey;

    private String city;

    private String country;

    private String language;

    private String province;

}
